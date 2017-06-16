package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 
3 3
4 4 
5 5 
6 6
7 7
8 8
9 9
61 61
 * @author Hoda
 *
 */

public class MarriageInterview10446 {
    static BigInteger[][] memo;
    static int n,count,back; //back-n-2 , 
    public static BigInteger dp(int n,int back){
	if(n <= 1)
	    return BigInteger.ONE;
	if(memo[n][back] != null)
	    return memo[n][back];
	BigInteger sum = BigInteger.ZERO;
	for (int i = 1; i <= back; i++)
	{
	   sum = sum.add(dp(n-i,back));
	}
	return memo[n][back] = BigInteger.ONE.add(sum);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 0;
	while(true){
	    n = bf.nextInt();
	    back = bf.nextInt();
	    if(n > 60)
		break;
	    if(n <= 1)
	    {
		out.println("Case " + (++cases) + ": 1");
		continue;
	    }
	    memo = new BigInteger[n+1][back+1];
	    out.println("Case " + (++cases) + ": " + dp(n,back).toString());
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
