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
6 2
6 3
6 4
-1 -1
 * @author Hoda
 *
 */

public class ChestDrawers11420 {
    static long [][][] memo;
    static int n,s;
    public static long dp(int sec,int draw, int prev){ //prev is 1 if locked, zero if unlocked
	if(draw == n && sec == 0)
	    return 1L;
	if(draw == n)
	    return 0L;
	if(memo[sec][draw][prev] != -1)
	    return memo[sec][draw][prev];
	long lock = 0L, lock2 = 0L, unlock = 0L;
	if(prev == 1 && sec-1 >= 0)
	    lock = dp(sec-1,draw+1,1);
	else if(prev == 0)
	    lock2 = dp(sec,draw+1,1);
	unlock = dp(sec,draw+1,0);
	return memo[sec][draw][prev] = lock + lock2 + unlock;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    n = bf.nextInt();
	    s = bf.nextInt();
	    if(n < 0 && s < 0)
		break;
	    memo = new long[s+1][n][2];
	    for (int i = 0; i < memo.length; i++)
	    {
		for (int j = 0; j < memo[i].length; j++)

		    Arrays.fill(memo[i][j], -1);
	    }
	    out.println(dp(s,0,1));
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
