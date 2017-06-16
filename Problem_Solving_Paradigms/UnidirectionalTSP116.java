package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class UnidirectionalTSP116 {
    static int[][] memo;
    public static int adjust(int n, int i){
	return i < 0?n-1: i >= n?0:i;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int r = bf.nextInt();
	    int c = bf.nextInt();
	    int [][] val = new int[r][c];
	    for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
		    val[i][j] = bf.nextInt();
	    memo = new int[r][c];
	    for (int i = 0; i < r; i++)
	    {
		memo[i][c-1] = val[i][c-1];
	    }
	    for (int j = c-2; j >= 0; j--)
	    {
		for (int i = 0; i < r; i++)
		{
		    memo[i][j] = Math.min(Math.min(memo[i][j+1], memo[adjust(r,i-1)][j+1]), memo[adjust(r,i+1)][j+1]) + val[i][j];
		}
	    }
	    int min = 0;
	    for (int i = 1; i < r; i++)
	    {
		if(memo[i][0] < memo[min][0])
		    min = i;
	    }
	    ArrayList<Integer> ans = new ArrayList<>();
	    ans.add(memo[min][0]);
	    ans.add(min);
	    int num = memo[min][0]-val[min][0];
	    for (int i = 0; i < c-1; i++)
	    {
		int [] tmp = {adjust(r,min-1), adjust(r,min),adjust(r,min+1)};
		Arrays.sort(tmp);
		for (int j = 0; j < tmp.length; j++)
		{
		    if(num == memo[tmp[j]][i+1]){
			num -= val[tmp[j]][i+1];
			ans.add(tmp[j]);
			min = tmp[j];
			break;
		    }

		}

	    }
	    for (int i = 1; i < ans.size(); i++)
	    {
		out.print((i > 1?" ":"") + (ans.get(i)+1));
	    }
	    out.println("\n"+ans.get(0));
	}
	out.flush();
	out.close();
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{
	    br = new BufferedReader(fileReader);	
	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if(x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for(int i = start; i < x.length(); i++)
		if(x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		}
		else
		{
		    sb.append(x.charAt(i));
		    if(dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg?-1:1);
	}

	public boolean ready() throws IOException {return br.ready();}
    }

}
