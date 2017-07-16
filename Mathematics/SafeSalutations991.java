package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SafeSalutations991 {
    static BigInteger [][] memo;
    static BigInteger nCr(int n, int k)
    {
	if(n < k)
	    return BigInteger.ZERO;
	if(k == 0 || k == n)
	    return BigInteger.ONE;
	if(memo[n][k] != null)
	    return memo[n][k];
	if(n-k < k)
	    return memo[n][k] = nCr(n, n-k);
	return memo[n][k] = nCr(n-1, k-1).add(nCr(n-1, k));
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	StringBuilder sb = new StringBuilder();
	memo = new BigInteger[500][500];
	int TC = 1;
	while(bf.ready())
	{
	    int n = bf.nextInt();
	    if(TC++ > 1)
		sb.append("\n");
	    sb.append(nCr(2*n, n).divide(BigInteger.valueOf(n+1))).append("\n");
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