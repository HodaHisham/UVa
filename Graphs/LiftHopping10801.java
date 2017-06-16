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

public class LiftHopping10801 {
    static final int INF = (int)1e9;	//don't increase, avoid overflow
    static ArrayList<Edge>[] adjList;
    static int V,time[];

    static int dijkstra(int S, int T)	//O(E log E)
    {
	int[] dist = new int[V];
	Arrays.fill(dist, INF);
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	dist[S] = 0;
	pq.add(new Edge(S, 0,0));						//may add more in case of MSSP (Mult-Source)
	while(!pq.isEmpty())
	{
	    Edge cur = pq.remove();
	    if(cur.node == T)						//remove if all computations are needed
		return dist[T];
	    if(cur.cost > dist[cur.node])			//lazy deletion
		continue;
	    for(Edge nxt: adjList[cur.node]){
		int cos = cur.cost + nxt.cost + (cur.elev > 0 && cur.elev != nxt.elev?60:0);
		if(cos < dist[nxt.node])
		    pq.add(new Edge(nxt.node, dist[nxt.node] = cos, nxt.elev));
	    }
	}
	return -1;
    }

    static class Edge implements Comparable<Edge>
    {
	int node, cost, elev;

	Edge(int a, int b, int c) { node = a;	cost = b; elev = c;}

	public int compareTo(Edge e){ return cost - e.cost;	}
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    V = 100; int n = bf.nextInt(), k = bf.nextInt();
	    time = new int[n+1];
	    adjList = new ArrayList[100];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Edge>();
	    }
	    for (int i = 1; i <= n; i++)
	    {
		time[i] = bf.nextInt();
	    }
	    for (int i = 1; i <= n; i++)
	    {
		String [] s = bf.nextLine().split(" ");
		for (int j = 0; j < s.length; j++)
		{
		    int u = Integer.parseInt(s[j]);
		    for (int l = j+1; l < s.length; l++)
		    {
			int v = Integer.parseInt(s[l]);
			adjList[u].add(new Edge(v, time[i]*Math.abs(v-u),i));
			adjList[v].add(new Edge(u, time[i]*Math.abs(v-u),i));
		    }
		}
	    }
	    int tmp = dijkstra(0, k);
	    out.println(tmp == -1?"IMPOSSIBLE":tmp);
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
