package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combinations369 {
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
	comb = new long[101][101];
	for(long [] i:comb)
	    Arrays.fill(i, -1);
	while(true){
	    int n = bf.nextInt(), m = bf.nextInt();
	    if(n + m == 0)
		break;
	    StringBuilder sb = new StringBuilder(""+n).append(" things taken ").append(m).append(" at a time is ");
	    out.println(sb.append(nCr1(n, m)).append(" exactly."));
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