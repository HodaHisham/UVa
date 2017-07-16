package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CriticalMass580 {
    static int n;
    static int dp(int idx, int prev) // prev == 0 -> U
    {
	if(idx == -1)
	    return 1;
	if(memo[idx][prev] != -1)
	    return memo[idx][prev];
	int ans = 0;
	int sz = prev == 0?idx-2:-1;
	sz = Math.max(-1,sz);
	for (int i = idx-1; i >= sz; i--)
	{
	    ans += dp(i,1-prev);
	}
	return memo[idx][prev] = ans;
    }
    static int [][] memo;
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	memo = new int[31][2];
	for(int []i:memo)
	    Arrays.fill(i, -1);
	while(true)
	{
	    n = bf.nextInt();
	    if(n == 0)
		break;
//	    out.println(n);
//	    out.println(dp(0,0));
//	    out.println(dp(0,1));
	    out.println((1<<n) - dp(n-1,0) - dp(n-1,1));
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