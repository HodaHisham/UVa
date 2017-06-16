package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MiceAndMaze1112 {
    static int n,e,t,m;
    static final int INF = (int)1e9;	
    static ArrayList<Edge>[] adjList;
    static int[]dist;
    static void dijkstra(int S)
    {
	dist = new int[n];
	Arrays.fill(dist, INF);
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	dist[S] = 0;
	pq.add(new Edge(S, 0));
	while(!pq.isEmpty())
	{
	    Edge cur = pq.remove();
	    if(cur.cost > dist[cur.node])
		continue;
	    for(Edge nxt: adjList[cur.node])
		if(cur.cost + nxt.cost < dist[nxt.node])
		{
		    dist[nxt.node] = cur.cost + nxt.cost;
		    pq.add(new Edge(nxt.node, dist[nxt.node]));
		}

	}
    }

    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = bf.nextInt();
	while(cases-->0){
	    n = bf.nextInt();
	    e = bf.nextInt()-1;
	    t = bf.nextInt();
	    m = bf.nextInt();
	    adjList = new ArrayList[n];
	    for (int i = 0; i < n; i++)
	    {
		adjList[i] = new ArrayList<Edge>();
	    }
	    for (int i = 0; i < m; i++)
	    {
		int u = bf.nextInt()-1;
		int v = bf.nextInt()-1;
		int w = bf.nextInt();
		adjList[v].add(new Edge(u,w));
	    }
	    int num = 0;
	    dijkstra(e);
	    for (int i = 0; i < n; i++)
	    {
		if(dist[i]<=t)
		    num++;
	    }
	    out.println(num);
            if(cases > 0) out.println();
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

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
	}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}


    }
    static class Edge implements Comparable<Edge>
    {
	int node, cost;

	Edge(int a, int b)
	{
	    node = a;
	    cost = b;
	}

	public int compareTo(Edge e)
	{
	    if(cost != e.cost)
		return cost - e.cost;
	    return node - e.node;
	}

    }
}
