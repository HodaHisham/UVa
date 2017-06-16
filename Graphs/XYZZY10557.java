package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class XYZZY10557 {
    static final int INF = -(int)1e9;	//don't increase, avoid overflow
    static ArrayList<Edge>[] adjList;
    static int V;
    static int dist[],adjMat [][];
    static boolean bellmanFord(int S)		
    {
	dist = new int[V];
	Arrays.fill(dist, INF);
	dist[S] = 100;
	boolean modified = true;
	for(int k = 0; modified && k < V - 1; ++k)
	{
	    modified = false;
	    for(int u = 0; u < V; ++u)		// these two loops run in O(E) in total
		for(Edge nxt: adjList[u])	
		    if(dist[u] + nxt.cost > dist[nxt.node])
		    {
			if(dist[u] + nxt.cost <= 0){
			    continue;
			}
			else{
			    modified = true;
			    dist[nxt.node] = dist[u] + nxt.cost;
			}
		    }
	}

	boolean hasNegCycle = false;
	for(int u = 0; u < V; ++u)
	    for(Edge nxt: adjList[u]){
		if(dist[u] + nxt.cost <= 0){
		    continue;
		}
		if(dist[u] + nxt.cost > dist[nxt.node])
		    hasNegCycle |= (adjMat[nxt.node][V-1]==1);
	    }
	return hasNegCycle;
    }

    static class Edge implements Comparable<Edge>
    {
	int node, cost;

	Edge(int a, int b) { node = a;	cost = b; }

	public int compareTo(Edge e){ return cost - e.cost;	}
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    V = bf.nextInt();
	    if(V == -1)break;
	    adjList = new ArrayList[V];
	    adjMat = new int[V][V];
	    for (int i = 0; i < adjList.length; i++)
		adjList[i] = new ArrayList<Edge>();
	    for (int i = 0; i < adjList.length; i++)
	    {
		int w = bf.nextInt(), k = bf.nextInt();
		for (int j = 0; j < k; j++)
		{
		    int u = bf.nextInt()-1;
		    adjList[i].add(new Edge(u, w));
		    adjMat[i][u] = 1;
		}
	    }
	    for(int k = 0; k < V; ++k)
		for(int i = 0; i < V; ++i)
		    for(int j = 0; j < V; ++j)
			adjMat[i][j] |= adjMat[i][k] & adjMat[k][j];

	    boolean flag = bellmanFord(0);
	    if(flag || dist[V-1] > 0)
		out.println("winnable");
	    else out.println("hopeless");
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
