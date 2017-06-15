package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class HoaxOrwhat11136 {


public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    TreeMap <Integer,Integer> m = new TreeMap<>();
	    long sum = 0;
	    for (int i = 0; i < n; i++)
	    {
		int k = bf.nextInt();
		for (int j = 0; j < k; j++)
		{
		    int inp = bf.nextInt();
		    Integer tmp = m.get(inp);
		    if(tmp == null) tmp = 0;
		    m.put(inp, tmp+1);
		}
		int f = m.firstKey(), s = m.lastKey();
		sum += s-f;
		Integer tmp = m.get(f);
		if(tmp > 1)
		    m.put(f, tmp-1);
		else m.remove(f);
		tmp = m.get(s);
		if(tmp > 1)
		    m.put(s, tmp-1);
		else m.remove(s);
	    }
	    out.println(sum);
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