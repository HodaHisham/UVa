package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ForwardingEmails12442 {

    static int adjList [];
    static int [] visited;
    static int [] dfs_num;

    public static int dfs(int u){
	int v = adjList[u];
	int r = 0;
	dfs_num[u] = 1;
	if(dfs_num[v] == 0){
	    r = dfs(v) + 1;
	}
	dfs_num[u] = 0;
	return visited[u] = r;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	for (int i = 1; i <= t; i++)
	{
	    int n = bf.nextInt();
	    adjList = new int[n];
	    for (int j = 0; j < n; j++)
	    {
		int u = bf.nextInt()-1, v = bf.nextInt()-1;
		adjList[u] = v;
	    }
	    visited = new int[n];
	    dfs_num = new int[n];
	    Arrays.fill(visited, -1);
	    int ans = 0, max = 0;
	    for (int k = 0; k < n; k++)
	    {
		if(visited[k] == -1)
		    dfs(k);
		if(visited[k] > max)
		{ ans = k+1; max = visited[k];}
	    }
	    out.println("Case " + i + ": " + ans);
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
