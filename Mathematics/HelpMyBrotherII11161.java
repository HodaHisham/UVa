package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class HelpMyBrotherII11161 {
    static BigInteger fib[];

    static BigInteger fibonacci(int n) 		//O(log n)
    {
	if (n == 0)
	    return fib[n] = BigInteger.ZERO;
	if (n <= 2)
	    return fib[n] = BigInteger.ONE;
	if (fib[n] != null)
	    return fib[n];

	int k = n >> 1;
	BigInteger a = fibonacci(k), b = fibonacci(k+1);

	if (n%2 == 0)
	    return fib[n] = a.multiply(b.multiply(BigInteger.valueOf(2)).subtract(a));
	return  fib[n] = b.multiply(b).add(a.multiply(a));
    }	
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	fib = new BigInteger[1600];
	for (int i = 0; i < fib.length; i++)
	{
	    fibonacci(i);
	}
	for (int i = 1; i < fib.length; i++)
	{
	    fib[i] = fib[i-1].add(fib[i]);
	}
	StringBuilder sb = new StringBuilder();
	int c = 1;
	while(true)
	{
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    BigInteger ans = (fib[n+1]).divide(BigInteger.valueOf(2)).subtract(BigInteger.ONE);
	    sb.append(String.format("Set %d:\n%d\n", c++,ans));
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