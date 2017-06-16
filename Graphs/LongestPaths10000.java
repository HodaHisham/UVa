package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class LongestPaths10000 {
    static int [] visited;
    static int ans;
    static ArrayList<Integer>[] adjList;
    static void bfs(int s)
    {
	Queue<Integer> q = new LinkedList<Integer>();
	q.add(s);
	visited[s] = 0;
	while(!q.isEmpty())
	{
	    int u = q.remove();
	    for(int v: adjList[u]){
		if(visited[v] < visited[u] + 1){
		    q.add(v);
		    visited[v] = visited[u] + 1;
		    if(visited[ans] < visited[v])
			ans = v;
		    else if(visited[ans] == visited[v] && v < ans)
			ans = v;
		}
	    }
	}
    }

    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    adjList = new ArrayList[n];
	    visited = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    int s = bf.nextInt();
	    while(true){
		int u = bf.nextInt();
		int v = bf.nextInt();
		if(u == 0 && v == 0)
		    break;
		u--; v--; 
		adjList[u].add(v);
	    }
	    s--;
	    ans = 0;
	    bfs(s);
	    out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n",cases++,s+1,visited[ans],ans+1);
	}
	out.flush();
	out.close();
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if(x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for(int i = start; i < x.length(); i++)
		if(x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		}
		else
		{
		    sb.append(x.charAt(i));
		    if(dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg?-1:1);
	}

	public boolean ready() throws IOException {return br.ready();}
    }

}
