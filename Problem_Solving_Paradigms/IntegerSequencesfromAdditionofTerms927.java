package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IntegerSequencesfromAdditionofTerms927 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int c = bf.nextInt();
	while(c-- > 0)
	{
	    int i = bf.nextInt();
	    int [] cf = new int[i+1];
	    for (int j = 0; j < cf.length; j++)
	    {
		cf[j] = bf.nextInt();
	    }
	    int d = bf.nextInt(), k = bf.nextInt();
	    long n = 1, m = d, t = d;
	    while(m < k)
	    {
		n++;
		d += t;
		m += d;
	    }
	    long ans = cf[0];
	    long tmp = n;
	    for (int j = 1; j < cf.length; j++)
	    {
		ans += cf[j]*n;
		n *= tmp;
	    }
	    out.println(ans);
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