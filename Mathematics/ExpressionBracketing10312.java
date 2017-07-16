package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class ExpressionBracketing10312 { //change to eof
    
 
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(new FileReader("A.txt"));
	PrintWriter out = new PrintWriter(System.out);
	long[]cat = new long[27];
	cat[0] = 1;
	for(int i = 1; i < 27; i++){
	    cat[i] = cat[i-1] * (4*i-2) / (i+1);
	}
	BigInteger [] ans = new BigInteger[27];
	ans[1] = BigInteger.ONE;
	ans[2] = BigInteger.ONE;
	for (int i = 3; i < ans.length; i++)
	{
	    ans[i] = BigInteger.valueOf(6*i-9).multiply(ans[i-1]).subtract(BigInteger.valueOf(i-3).multiply(ans[i-2])).divide(BigInteger.valueOf(i));
	}
//	out.println(Arrays.toString(ans));
//	out.println(Arrays.toString(cat));
        while(bf.ready()){
            int n = bf.nextInt();
            out.println(ans[n].subtract(BigInteger.valueOf(cat[n-1])));
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
