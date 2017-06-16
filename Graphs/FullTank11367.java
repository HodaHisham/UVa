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

public class FullTank11367 {
    static final int INF = (int)1e8;	//don't increase, avoid overflow
    //static ArrayList<Edge>[] adjList;
    static ArrayList<Edge>[] adjList2;
    static int V,c,e;
    static int[]price;
    static int dijkstra(int S)
    {
	int[][] money = new int[V][c+1];
        for (int i = 0; i < V; ++i)
	{
	    Arrays.fill(money[i],INF);
	}
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	money[S][0] = 0;
	pq.add(new Edge(S,0,0));
	while(!pq.isEmpty())
	{
	    Edge cur = pq.remove();
	    if(cur.node == e){
		return cur.cost;
	    }
	    if(cur.cost > money[cur.node][cur.fuel])
		continue;
	    for(Edge nxt: adjList2[cur.node]){
		    if(cur.fuel >= nxt.cost && cur.cost < money[nxt.node][cur.fuel-nxt.cost])
		    {
			money[nxt.node][cur.fuel-nxt.cost] = cur.cost;
			pq.add(new Edge(nxt.node, cur.cost, cur.fuel-nxt.cost));
		    }
	    }
	    if(cur.fuel<c && cur.cost + price[cur.node] < money[cur.node][cur.fuel+1]){
		money[cur.node][cur.fuel+1] = cur.cost + price[cur.node];
		pq.add(new Edge(cur.node, cur.cost + price[cur.node], cur.fuel+1));
	    }
	}
	return INF;
    }

    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	V = bf.nextInt();
	int m = bf.nextInt();
	price = new int[V];
	adjList2 =  new ArrayList[V];
	for (int i = 0; i < adjList2.length; i++)
	{
	    adjList2[i] = new ArrayList<Edge>();
	}
	for (int i = 0; i < V; i++)
	{
	    price[i] = bf.nextInt();
	}
	for (int i = 0; i < m; i++)
	{
	    int u = bf.nextInt();
	    int v = bf.nextInt();
	    int d = bf.nextInt();
	    adjList2[u].add(new Edge(v,d,-1));
	    adjList2[v].add(new Edge(u,d,-1));
	}
	int q = bf.nextInt();
	for (int i = 0; i < q; i++)
	{
	    c = bf.nextInt();
	    int s = bf.nextInt();
	    e = bf.nextInt();
	    int res = dijkstra(s);
	    out.println(res == INF ? "impossible": res);
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
	int node, cost, fuel;

	Edge(int a, int b, int c)
	{
	    node = a;
	    cost = b;
	    fuel = c;
	}

	public int compareTo(Edge e)
	{
	    if(cost != e.cost)
		return cost - e.cost;
	    return price[node] - price[e.node];
	}

    }
}
