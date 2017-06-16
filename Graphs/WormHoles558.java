package Graphs;

import java.io.*;
import java.util.*;

public class WormHoles558 {
    static ArrayList<Edge> adjList [];
    static int V,E, INF = (int) 1e9;
    public static boolean bellman_Ford(int S){
	int [] dist = new int[V];
	Arrays.fill(dist, INF);
	dist[S] = 0;
	boolean modified = true;
	for (int i = 0; modified && i < V-1; i++)
	{
	    modified = false;
	    for (int u = 0; u < V; u++)
	    {
		for(Edge e : adjList[u]){
		    if(dist[u] + e.cost < dist[e.to]){
			modified = true;
			dist[e.to] = dist[u] + e.cost;
		    }
		}
	    }
	}
	boolean negative = false;
	for (int u = 0; u < V ; u++)
	{
	    for (Edge e : adjList[u])
	    {
		if(dist[u] + e.cost < dist[e.to])
		    negative  = true;
	    }
	}
	return negative;
    }
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int t = Integer.parseInt(st.nextToken());
	while(t-->0 ){
	    st = new StringTokenizer(bf.readLine());
	    V = Integer.parseInt(st.nextToken());
	    E = Integer.parseInt(st.nextToken());
	    adjList = new ArrayList[V];
	    for (int i = 0; i < adjList.length; i++)
		adjList[i] = new ArrayList<Edge>();
	    for (int i = 0; i < E; i++)
	    {
		st = new StringTokenizer(bf.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());
		adjList[u].add(new Edge(v,cost));
			
	    }


	    if(bellman_Ford(0))
		out.println("possible");
	    else
		out.println("not possible");
	}
	out.flush();
	out.close();
    }
    static class Edge implements Comparable{
	int to,cost;
	public Edge(int t, int c){
	    to = t;
	    cost = c;
	}
	public int compareTo(Object o){
	    Edge e = (Edge) o;
	    if(cost != e.cost)
		return cost - e.cost;
	    return to - e.to;
	}
    }
}
