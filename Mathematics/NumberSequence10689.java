package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberSequence10689 {
   

    public static int add(long x, long y, int z)
    {
	return (int) ((x + y) % z);
    }
    public static int mul(long x, long y, int z)
    {
	return (int) ((x * y) % z);
    }
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
	    return fib[n] = (b.multiply(BigInteger.valueOf(2)).subtract(a)).multiply(a);
	return  fib[n] = b.multiply(b).add(a.multiply(a));
    }	
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int T = bf.nextInt();
	fib = new BigInteger[15001];
	for (int i = 0; i < fib.length; i++)
	{
	    if(fib[i] == null)
		fibonacci(i);
	}
	int modular [] = {60, 300, 1500, 15000};
	int [] pten = {10, 100, 1000, 10000};
	
	while(T-- > 0){
	    int a = (bf.nextInt());
	    int b = (bf.nextInt());
	    int n = bf.nextInt();
	    int m = bf.nextInt()-1;
            int mod = modular[m];
            int ten = pten[m];
//            System.out.println(n+" "+mod);
	    out.println(n == 0?a:add(mul(fib[(n-1)%mod].mod(BigInteger.valueOf(ten)).intValue(),a,ten),mul(fib[(n)%mod].mod(BigInteger.valueOf(ten)).intValue(),b,ten),ten));
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

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if (x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for (int i = start; i < x.length(); i++)
		if (x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		} else
		{
		    sb.append(x.charAt(i));
		    if (dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg ? -1 : 1);
	}

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if (line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
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
