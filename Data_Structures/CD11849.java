package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CD11849 {


public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt(), m = bf.nextInt();
	    if(n == 0 && m == 0)
		break;
	    TreeSet<Integer> set = new TreeSet<>();
	    for (int i = 0; i < n; i++)
	    {
		set.add(bf.nextInt());
	    }
	    int ans = 0;
	    for (int i = 0; i < m; i++)
	    {
		int tmp = bf.nextInt();
		if(set.contains(tmp)){
		    ans++;
		    set.remove(tmp);
		}
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