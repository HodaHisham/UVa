package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChange674 {
    static int [][] memo;
    static int n;
    static int[] con = {50,25,10,5,1};
    public static int max(int ind,int rem){
	if(rem == 0)
	    return 1;
	if(ind == 5)
	    return 0;
	if(memo[ind][rem] != -1 )
	    return memo[ind][rem];
	int sol1 = 0, sol2 = 0;
	if(rem - con[ind] >= 0){
	    sol1 = max(ind,rem - con[ind]);
	}
	sol2 = max(ind+1,rem);
	return memo[ind][rem] = sol1 + sol2;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	String s = bf.nextLine();
	while(s != null){
	    StringTokenizer st  = new StringTokenizer(s);
	    n = Integer.parseInt(st.nextToken());
	    memo = new int[5][n+1];
	    for (int i = 0; i < 5; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    out.println(max(0,n));
	    s = bf.nextLine();
	}
	out.flush();
	out.close();
    }
    /**
     * 
     * 

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
