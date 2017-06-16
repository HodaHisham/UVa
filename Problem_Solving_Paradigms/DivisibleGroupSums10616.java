
package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DivisibleGroupSums10616 {

    static long [][][] memo;
    static int m, d;
    static int[] num;
    public static long dp(int ind, int mod, int rem){
	if(rem == 0)
	    return mod%d==0?1:0;
	if(ind == num.length)
	    return 0;
	if(memo[ind][mod][rem] != -1)
	    return memo[ind][mod][rem];
	return memo[ind][mod][rem] = dp(ind+1,mod,rem) + dp(ind+1,(int)((0L+mod+(num[ind]%d+d)%d)%d),rem-1);
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    int n = bf.nextInt(); int q = bf.nextInt();
	    if(n == 0 && q == 0)
		break;
	    num = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		num[i] = bf.nextInt();
	    }
	    out.println("SET " + cases++ + ":");
	    for (int i = 1; i <= q; i++)
	    {
		d = bf.nextInt(); m = bf.nextInt();
		memo = new long[n+1][d+1][m+1];
		for (int k = 0; k < memo.length; k++)
		    for(int j = 0; j < memo[0].length; j++)
			Arrays.fill(memo[k][j], -1);
		out.println("QUERY "+i+": "+dp(0,0,m));		
	    }
	}
	out.flush();
	out.close();
    }

    static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s)
	{
	    br = new BufferedReader(new InputStreamReader(s));
	}

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

	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}

	public String nextLine() throws IOException
	{
	    return br.readLine();
	}

	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}
