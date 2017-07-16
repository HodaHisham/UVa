package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class LeadingandTrailing11029 {
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int T = bf.nextInt();
	while(T-->0){
	    int n = bf.nextInt();
	    int k = bf.nextInt();
	    int l = (int) (Math.pow(10,(k*Math.log10(n))%1)*100);
	    int t = bigMod(n, k, 1000);
	    out.printf("%03d...%03d\n",l,t);
	}
	out.flush();
	out.close();
    }
    static int bigMod(int a, int e, int mod)	// O(log e)
	{
		a %= mod;
		int res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			e >>= 1;
		}
		return res;
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
