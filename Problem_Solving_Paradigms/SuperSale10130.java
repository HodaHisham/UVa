package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * 
2
3
72 17
44 23
31 24
1 26
6
64 26
85 22
52 4
99 18
39 13
54 9
4
23
20
20
26
 *
 */
public class SuperSale10130 {
    static int[] prices,weights,maxW;
    static int [][] memo;
    static int n;
    public static int max(int ind, int remW){
	if(ind == n || remW <= 0)
	    return 0;
	if(memo[ind][remW] != -1)
	    return memo[ind][remW];
	int take = 0;
	if(remW - weights[ind] >= 0)
	    take = prices[ind] + max(ind+1, remW - weights[ind]);
	int leave = max(ind+1, remW);
	return memo[ind][remW] = Math.max(take, leave);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	while(t-->0 ){
	    n = bf.nextInt();
	    prices = new int[n];
	    weights = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		prices[i] = bf.nextInt();
		weights[i] = bf.nextInt();
	    }
	    int g = bf.nextInt();
	    maxW = new int[g];
	    for (int i = 0; i < g; i++)
	    {
		maxW[i] = bf.nextInt();

	    }
	    int res = 0;
	    for (int i = 0; i < g; i++)
	    {
		memo = new int[n][maxW[i]+1];
		for (int j = 0; j < memo.length; j++)
		{
		    Arrays.fill(memo[j], -1);
		}
		res += max(0, maxW[i]);
	    }
	    out.println(res);
	}
	out.flush();
	out.close();
    }
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
