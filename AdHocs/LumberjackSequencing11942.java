package AdHocs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LumberjackSequencing11942 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	out.println("Lumberjacks:");
	for (int i = 0; i < n; i++)
	{
	    boolean flag = true;
	    int f = bf.nextInt(), s = bf.nextInt(),d = 0, d2 = 0;
	    for (int j = 0; j < 8; j++)
	    {
		int tmp = bf.nextInt(); d = s - f; d2 = tmp - s;
		flag &= d < 0 && d2 < 0 || d > 0 && d2 > 0;
		f = s;
		s = tmp;
	    }
	    out.println(flag?"Ordered":"Unordered");
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