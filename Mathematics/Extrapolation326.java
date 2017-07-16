package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Extrapolation326 {
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while (true)
	{
	    int n = bf.nextInt();
	    if (n == 0)
		break;
	    int[][] val = new int[n][];
	    val[0] = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		val[0][i] = bf.nextInt();
	    }
            for (int i = 1; i < n; i++)
	    {
		val[i] = new int[n-i];
		for (int j = 0; j < val[i].length; j++)
		{
		    val[i][j] = val[i-1][j+1] - val[i-1][j];
//			out.println(Arrays.toString(val[i]));

		}
	    }
            int k = bf.nextInt();
            int [] cur = new int[n];
            int [] prev = new int[n];
            for (int i = 0; i < prev.length; i++)
	    {
		prev[i] = val[i][val[i].length-1];
	    }
            for (int i = 0; i < k; i++)
	    {
		cur[n-1] = prev[n-1];
		for (int j = n-2; j >= 0; j--)
		{
		    cur[j] = prev[j] + cur[j+1];
		}
		prev = cur;
	    }
//	    int ans = val[n-1][0];
//	    for (int i = n-2; i >= 0; i--)
//	    {
//		ans = k*(2*val[i][val[i].length-1] + (k-1)*ans)/2;
//	    }
            out.println("Term " + (n+k) + " of the sequence is " + cur[0]);
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
