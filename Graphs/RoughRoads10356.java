package Graphs;

import java.io.*;
import java.util.*;

public class RoughRoads10356 {
    static ArrayList<Pair> adjList [];
    static int n;
    static int INF = (int)1e9;
    public static int dijkstra(){
	int [][]dist = new int[n][2];
	PriorityQueue<Triple> pq = new PriorityQueue<Triple>();
	for (int i = 0; i < dist.length; i++)
	    Arrays.fill(dist[i], INF);
	dist[0][0] = 0;
	pq.add(new Triple(0,0,0));
	while(!pq.isEmpty())
	{
	    Triple t = pq.remove();
	    if(t.cycle ==1 && dist[t.dest][1] < t.cost || t.cycle == 0 && dist[t.dest][0] < t.cost)
		continue;
	    for (Pair p : adjList[t.dest] )
	    {
		int d = p.cost + t.cost;
		if(d < dist[p.dest][t.cycle ^ 1]){
		    dist[p.dest][t.cycle^1]  = d;
		    pq.add(new Triple(p.dest, d , t.cycle^1));
		}
	    }
	}
	return dist[n-1][0]; // last should be riding
    }
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String s = bf.readLine();
	int i = 1;
	while(s != null){
	    StringTokenizer st = new StringTokenizer(s);
	    n = Integer.parseInt(st.nextToken());
	    int r = Integer.parseInt(st.nextToken());
	    adjList = new ArrayList[n];
	    for (int j = 0; j < n; j++)
	    {
		adjList[j] = new ArrayList<Pair>();
	    }
	    for (int i1 = 0; i1 < r; i1++)
	    {
		st = new StringTokenizer(bf.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());
		adjList[u].add(new Pair(v,cost));
		adjList[v].add(new Pair(u,cost));
	    }
	    int count = dijkstra();
	    out.println("Set #"+(i++));
	    if(count == INF)
		out.println("?");
	    else
		out.println(count);
	    s = bf.readLine();
	}
	out.flush();
	out.close();
    }
    static class Triple implements Comparable{
	int cycle; 
	int dest;
	int cost;
	public Triple(int d, int c, int cy){
	    dest = d;
	    cost = c;
	    cycle = cy;
	}
	public int compareTo(Object o){
	    Triple t = (Triple) o;
	    if(cost != t.cost)
	    return cost - t.cost;
	    else
		return dest - t.dest;
	}
    }
    static class Pair {
	int dest;
	int cost;
	public Pair(int d, int c){
	    dest = d;
	    cost = c;
	}

    }
}
/**
3 3
0 1 10
0 2 10
1 2 10
4 4
0 1 10
0 2 10
1 2 10
2 3 10
**/
