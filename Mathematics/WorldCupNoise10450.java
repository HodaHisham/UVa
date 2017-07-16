package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WorldCupNoise10450 {

    static long[][] comb;			//may need BigInteger, if the numbers are large, use a treemap

    static long nCr1(int n , int k)
    {
	if(n < k)
	    return 0;
	if(k == 0 || k == n)
	    return 1;
	if(comb[n][k] != -1)
	    return comb[n][k];
	if(n - k < k)
	    return comb[n][k] = nCr1(n, n - k);
	return comb[n][k] = nCr1(n - 1, k - 1) + nCr1(n - 1, k);
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	StringBuilder sb = new StringBuilder();
	comb = new long [55][55];
	for(long [] i:comb)
	    Arrays.fill(i, -1);
	for (int i = 1; i <= TC; i++)
	{
	    int n = bf.nextInt();
	    long ans = 0L;
	    for (int j = 0; j < n; j++)
	    {
		ans += nCr1(n-j+1, j);
	    }
	    if(n == 1)
		ans++;
	    sb.append(String.format("Scenario #%d:\n%d\n\n", i,ans));
	}
	out.print(sb);
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