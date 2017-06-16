package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SendingEmail10986 {
    static final int INF = (int)1e9;	//don't increase, avoid overflow
    static ArrayList<Edge>[] adjList;
    static int V;
    static int dijkstra(int S, int T)	//O(E log E)
    {
	int[] dist = new int[V];
	Arrays.fill(dist, INF);
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	dist[S] = 0;
	pq.add(new Edge(S, 0));						//may add more in case of MSSP (Mult-Source)
	while(!pq.isEmpty())
	{
	    Edge cur = pq.remove();
	    if(cur.node == T)						//remove if all computations are needed
		return dist[T];
	    if(cur.cost > dist[cur.node])			//lazy deletion
		continue;
	    for(Edge nxt: adjList[cur.node])
		if(cur.cost + nxt.cost < dist[nxt.node])
		    pq.add(new Edge(nxt.node, dist[nxt.node] = cur.cost + nxt.cost ));
	}
	return -1;
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
	int TC = bf.nextInt();
	for (int i = 1; i <= TC; i++)
	{
	    V = bf.nextInt(); int m = bf.nextInt(), S = bf.nextInt(), T = bf.nextInt();
	    adjList = new ArrayList[V];
	    for (int j = 0; j < adjList.length; j++)
	    {
		adjList[j] = new ArrayList<Edge>();
	    }
	    for (int j = 0; j < m; j++)
	    {
		int u = bf.nextInt(), v = bf.nextInt(), w = bf.nextInt();
		adjList[u].add(new Edge(v, w));
		adjList[v].add(new Edge(u, w));
	    }
	    int tmp = dijkstra(S, T);
	    out.println("Case #" + i+ ": " + (tmp == -1?"unreachable":tmp));
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
