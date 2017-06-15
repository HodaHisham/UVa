package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DoYourOwnHomework11917 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	StringBuilder sb = new StringBuilder();
	for (int i = 1; i <= TC; i++)
	{
	    int n = bf.nextInt();
	    TreeMap<String, Integer> mp = new TreeMap<>();
	    for (int j = 0; j < n; j++)
	    {
		mp.put(bf.next(), bf.nextInt());
	    }
	    Integer d = bf.nextInt(), t = mp.get(bf.next());
	    sb.append("Case ").append(i).append(": ").append(t == null?"Do your own homework!\n":t <= d?"Yesss\n": t <= d+5?"Late\n":"Do your own homework!\n");
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