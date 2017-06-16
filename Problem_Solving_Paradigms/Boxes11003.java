package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 5
19 15
7 13
5 7 
6 8
1 2
0
 * @author Hoda
 *
 */
public class Boxes11003 {
    static int [][] memo;
    static int[] weight,maxLoad;
    static int n;
    public static int max(int ind, int minLoad){
	if(ind == n)
	    return 0;
	if(memo[ind][minLoad] != -1 )
	    return memo[ind][minLoad];
	int take = 0, leave = 0;
	if(minLoad - weight[ind] >= 0){
	    take = 1 + max(ind+1,Math.min(minLoad == 3001?maxLoad[ind]:minLoad - weight[ind], maxLoad[ind]));
	}
	leave = max(ind+1,minLoad);
	return memo[ind][minLoad] = Math.max(take, leave);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    n = bf.nextInt();
	    if(n==0)
		break;
	    weight = new int[n];
	    maxLoad = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		weight[i] = bf.nextInt();
		maxLoad[i] = bf.nextInt();
	    }
	    memo = new int[n+1][3002];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    out.println(max(0,3001));
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

