package Graphs;

import java.io.*;
import java.util.*;

public class StreetDirections610 {
    static int N;
    static int M;
    static int[][] edges;


    static ArrayList<Integer>[] adjList;

    static int counter;

    static int[] dfs_num;
    static int[] dfs_low;
    static int[] parent;
    static boolean[] visited;
    static boolean[] aPoints;

    public static void dfs(int u)
    {
	visited[u] = true;
	dfs_num[u] = dfs_low[u] = ++counter;
	for(int i = 0; i < adjList[u].size(); i++)
	{
	    int v = adjList[u].get(i);
	    if(dfs_num[v] == 0)
	    {
		parent[v] = u;
		edges[u][v] = 1;
		dfs(v);
		if(dfs_low[v]>dfs_num[u])
		    edges[v][u] = 1;
		dfs_low[u] = Math.min(dfs_low[u],dfs_low[v]);
	    }
	    else
	    {
		if(v!=parent[u])
		{
		    dfs_low[u] = Math.min(dfs_low[u],dfs_num[v]);
		    edges[u][v] = 1;
		    if(adjList[v].contains(u))
			adjList[v].remove(adjList[v].indexOf(u));
		}

	    }

	}
    }
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int set = 1;
	while(true)
	{
	    StringTokenizer st = new StringTokenizer(bf.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    if(N == 0 && M==0 )
		break;
	    out.println(set++ +"\n");
	    edges = new int[N][N];
	    adjList = new ArrayList[N];
	    for(int i = 0; i < N; i++)
	    {
		adjList[i] = new ArrayList<Integer>();

	    }

	    while(M-->0)
	    {
		st = new StringTokenizer(bf.readLine());
		int i = Integer.parseInt(st.nextToken()) - 1;
		int j = Integer.parseInt(st.nextToken()) - 1;
		//System.out.println(i+ " " + j);
		adjList[i].add(j);
		adjList[j].add(i);
	    }

	    for(int i = 0; i < N; i++)
		Collections.sort(adjList[i]);
	    dfs_num = new int[N];
	    dfs_low = new int[N];
	    parent = new int[N];
	    visited = new boolean[N];

	    dfs(0);
	    for(int i = 0; i < edges.length; i++)
		for(int j = 0; j < edges.length; j++)
		    if(edges[i][j]==1)
			out.println((i+1)+" "+(j+1));
	    out.println("#");
	}
	out.flush();
	out.close();
    }


}	
