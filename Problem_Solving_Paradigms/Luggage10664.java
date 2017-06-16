package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//import Ch3.SuperSale.Scanner;

public class Luggage10664 {
    static ArrayList<Integer> weights;
    static int [][][] memo;
    static int n;
    public static int max(int ind, int W1,int W2){
	if(ind == n)
	    return W1 == W2? 1:0;
	if(memo[ind][W1][W2] != -1 )
	    return memo[ind][W1][W2];
	int take = max(ind+1, W1 + weights.get(ind),W2);
	int leave = max(ind+1, W1,W2 + weights.get(ind));

	return memo[ind][W1][W2] = Math.max(take, leave);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	while(t-->0 ){
	    weights = new ArrayList<Integer>();
	    String s = bf.nextLine();
	    StringTokenizer st  = new StringTokenizer(s);
	    while(st.hasMoreTokens())
	    {
		weights.add(Integer.parseInt(st.nextToken()));
	    }
	    n = weights.size();
	    memo = new int[n][201][201];
	    for (int j = 0; j < memo.length; j++)
	    {
		for (int i = 0; i < memo[j].length; i++)
		{
		    Arrays.fill(memo[j][i], -1);
		}
		
	    }
	    int res = max(0,0,0);
	    out.println(res == 1 ? "YES":"NO");
	}
	out.flush();
	out.close();
    }
    /**
     * 
     * 
3
1 2 1 2 1
2 3 4 1 2 5 10 50 3 50
3 5 2 7 1 7 5 2 8 9 1 25 15 8 3 1 38 45 8 1
     *
     */
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

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

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
	}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}


    }
}
