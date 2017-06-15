package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GreyCodes11173 {


public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int tc = bf.nextInt();
	long [] pow = new long[32];
	pow[0] = 1;
	for (int i = 1; i < pow.length; i++)
	{
	    pow[i] = pow[i-1]*2;
	}
	while(tc-->0){
	    int n = bf.nextInt(), k = bf.nextInt();
	    StringBuilder sb = new StringBuilder();
	    for (int i = n; i >= 1; i--)
	    {
		sb.append(((k%pow[i]>=pow[i-1]?1:0)^((k%pow[i+1]>=pow[i])?1:0)));
	    }
	    out.println(Integer.parseInt(sb.toString(),2));
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