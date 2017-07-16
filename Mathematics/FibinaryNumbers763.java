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

public class FibinaryNumbers763 {
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
	fib = new BigInteger[200];
	for(int i = 0; i < fib.length;i++){
	    fibonacci(i);
	}
	int TC = 1;
	StringBuilder sb = new StringBuilder();
	while(bf.ready())
	{
	    if(TC++ != 1)
		sb.append("\n");
	    char [] a = bf.next().toCharArray();
	    char [] b = bf.next().toCharArray();
	    BigInteger f = new BigInteger("0");
	    BigInteger s = new BigInteger("0");
	    for (int i = a.length-1, j = 2; i >= 0; i--, j++)
	    {
		if(a[i] == '1')
		    f = f.add(fib[j]);
	    }
	    for (int i = b.length-1, j = 2; i >= 0; i--, j++)
	    {
		if(b[i] == '1')
		    s = s.add(fib[j]);
	    }
	    f = f.add(s);
	    int tmp = -1;
	    if(f.compareTo(BigInteger.ZERO) == 0)
		sb.append('0');
	    while(f.compareTo(BigInteger.ZERO) > 0)
	    {
		int idx = Arrays.binarySearch(fib, f);
		if(idx < 0) idx = -(idx+1)-1;
		f = f.subtract(fib[idx]);
		if(tmp == -1)
		    tmp = idx;
		while(tmp-- > idx){
		    sb.append('0');
//		    System.out.println(tmp + " "+idx);
		}
		sb.append('1');
	    }
	    while(tmp-- > 1){
//		    System.out.println(tmp);
		sb.append('0');
	    }
	    
	    sb.append("\n");
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