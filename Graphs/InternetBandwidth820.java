package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class InternetBandwidth820 {

    static final int INF = (int)1e9;
    static int V, s, t, res[][];			//input
    static ArrayList<Integer>[] adjList;	//input
    static int[] ptr, dist;

    static int dinic()						//O(V^2E)
    {
	int mf = 0;
	while(bfs())
	{
	    ptr = new int[V];
	    int f;
	    while((f = dfs(s, INF)) != 0)
		mf += f;
	}
	return mf;
    }

    static boolean bfs()
    {
	dist = new int[V];
	Arrays.fill(dist, -1);
	dist[s] = 0;
	Queue<Integer> q = new LinkedList<Integer>();
	q.add(s);
	while(!q.isEmpty())
	{
	    int u = q.remove();
	    if(u == t)
		return true;
	    for(int v: adjList[u])
		if(dist[v] == -1 && res[u][v] > 0)
		{
		    dist[v] = dist[u] + 1;
		    q.add(v);
		}
	}
	return false;
    }

    static int dfs(int u, int flow)
    {
	if(u == t)
	    return flow;
	for(int i = ptr[u]; i < adjList[u].size(); i = ++ptr[u])
	{
	    int v = adjList[u].get(i);
	    if(dist[v] == dist[u] + 1 && res[u][v] > 0)
	    {
		int f = dfs(v, Math.min(flow, res[u][v]));
		if(f > 0)
		{
		    res[u][v] -= f;
		    res[v][u] += f;
		    return f;
		}
	    }
	}
	return 0;

    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    V = n;
	    adjList = new ArrayList[n];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    res = new int[n][n];
	    s = bf.nextInt()-1; t = bf.nextInt()-1; int c = bf.nextInt();
	    for (int i = 0; i < c; i++)
	    {
		int u = bf.nextInt()-1, v = bf.nextInt()-1, w = bf.nextInt();
		if(!adjList[u].contains(v))
		    adjList[u].add(v);
		if(!adjList[v].contains(u))
		    adjList[v].add(u);
		res[u][v] += w;
		res[v][u] += w;
	    }
	    out.println("Network " + cases++);
	    out.println("The bandwidth is " + dinic() + ".");
	    out.println();
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
