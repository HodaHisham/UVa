package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PruneList12049 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    int n = bf.nextInt(), m = bf.nextInt();
	    TreeMap <Integer,Integer> map = new TreeMap<>();
	    for (int i = 0; i < n; i++)
	    {
		int inp = bf.nextInt();
		Integer tmp = map.get(inp);
		if(tmp == null) tmp = 0;
		map.put(inp,tmp+1);	
	    }
	    int ans = 0;
	    for (int i = 0; i < m; i++)
	    {
		int inp = bf.nextInt();
		Integer tmp = map.get(inp);
		if(tmp == null)
		    ans++;
		else{
		    if(tmp > 1)
			map.put(inp,tmp-1);
		    else map.remove(inp);
		}
	    }
	    for(int i:map.keySet())
		ans += map.get(i);
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