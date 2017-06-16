package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Howdoyouadd10943 {
    static int [][] memo;
    static int mod = (int)1e6;
    public static int dp(int n, int k){
	if(k == 1)
	    return 1;
	if(memo[n][k] != -1)
	    return memo[n][k];
	long ans = 0;
	for (int i = 0; i <= n; i++)
	{
	    ans = (ans + dp(n-i,k-1))%mod;
	}
	return memo[n][k] = (int)ans;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	memo = new int[101][101];
	for (int i = 0; i < memo.length; i++)
	{
	    Arrays.fill(memo[i],-1);
	}
	while(true){
	    int n = bf.nextInt(), k = bf.nextInt();
	    if(n == 0 && k == 0)
		break;
	    out.println(dp(n,k));
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
