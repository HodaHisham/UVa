package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BarCodes10721 { //change loop to eof

    static long [][][] memo;
    static int w;
    public static long dp(int n, int k, int m){
	if(n == 0)
	    return k==1?1:0;
	if(memo[n][k][m] != -1)
	    return memo[n][k][m];
	long ans = 0;
	if(k-1 >= 1)
	    ans += dp(n-1,k-1,w-1) ; //different
	if(m-1 >= 0)
	    ans += dp(n-1,k,m-1); //same as previous
	//	System.out.println(n + " " + k + " " +m + " " + ans);
	return memo[n][k][m] = ans;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	while(bf.ready()){
	    int n = bf.nextInt(), k = bf.nextInt(), m = bf.nextInt();
	    w = m;
	    memo = new long[51][51][51];
	    for (int i = 0; i < memo.length; i++)
	    {
		for (int j = 0; j < memo[i].length; j++)
		{
		    Arrays.fill(memo[i][j], -1);
		}
	    }
	    out.println(dp(n-1,k,m-1));
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
