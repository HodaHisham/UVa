package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MischievousChildren10338 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	long [] fac = new long[21]; fac[0] = 1;
	for (int i = 1; i < fac.length; i++)
	    fac[i] = fac[i-1] * i;
	int TC = bf.nextInt();
	for (int i = 1; i <= TC; i++)
	{
	    char [] s = bf.next().toCharArray();
	    long ans = 1;
	    int [] occ = new int[26];
	    for (int j = 0; j < s.length; j++)
	    {
		occ[s[j]-'A']++;
	    }
	    for (int j = 0; j < occ.length; j++)
	    {
		ans *= fac[occ[j]];
	    }
	    out.println("Data set " + i + ": " + fac[s.length]/ans);
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
