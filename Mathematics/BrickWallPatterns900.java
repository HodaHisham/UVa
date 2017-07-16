package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BrickWallPatterns900 {
    static long fib[];

    static long fibonacci(int n) 		//O(log n)
    {
	if (n == 0)
	    return 0;
	if (n <= 2)
	    return 1;
	if (fib[n] != -1)
	    return fib[n];

	int k = n >> 1;
	long a = fibonacci(k), b = fibonacci(k+1);

	if (n%2 == 0)
	    return fib[n] = a * (2 * b - a);
	return  fib[n] = b * b + a * a;
    }	
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	fib = new long[52];
	Arrays.fill(fib, -1);
	while(true)
	{
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    out.println(fibonacci(n+1));
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