package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BruteLock1235 {

    static ArrayList<Edge>[] adjList;
    static int V;

    static int prim()		//O(E log E)
    {
	int mst = 0;
	boolean[] visited = new boolean[V];
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	pq.add(new Edge(0, 0));
	while(!pq.isEmpty())
	{
	    Edge cur = pq.remove();
	    if(visited[cur.node])
		continue;
	    visited[cur.node] = true;
	    mst += cur.cost;
	    for(Edge nxt: adjList[cur.node])
		if(!visited[nxt.node])
		    pq.add(nxt);
	}	
	return mst;
    }
    static class Edge implements Comparable<Edge>
    {
	int node, cost;

	Edge(int a, int b) { node = a; cost = b; }

	public int compareTo(Edge e) { return cost - e.cost; }

    }
    public static int cost(int x, int y){
	int ans = 0;
	//	System.out.print(x + " " + y );
	for (int i = 0; i < 4; i++)
	{
	    int dx = x%10, dy = y%10;
	    ans += Math.min(Math.abs(dx-dy),Math.min(Math.abs(dx+10-dy),Math.abs(10-dx+dy)));
	    x/=10;
	    y/=10;
	}
	//	System.out.println(" " + ans);
	return ans;
    }
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	while(n-- > 0){
	    int k = bf.nextInt();
	    V = k+1;
	    int [] val = new int[k];
	    for (int i = 0; i < k; i++)
		val[i] = bf.nextInt();
	    adjList = new ArrayList[k]; 
	    for (int i = 0; i < adjList.length; i++)
		adjList[i] = new ArrayList<Edge>();
	    int ans = 9*4;
	    for (int i = 0; i < val.length; i++)
	    {
		int c = 0, tmp = val[i];
		for (int j = 0; j < 4; j++)
		{
		    c += Math.min(tmp%10,10-tmp%10);
		    tmp/=10;
		}
		ans = Math.min(ans, c);
	    }
	    for (int i = 0; i < k; i++)
	    {
		for (int j = i+1; j < val.length; j++)
		{
		    int c =  cost(val[i],val[j]);
		    adjList[i].add(new Edge(j, c));
		    adjList[j].add(new Edge(i, c));
		}
	    }
	    out.println(ans+prim());
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
