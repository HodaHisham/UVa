package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CriticalLinks796 { //change to System.in

    static ArrayList<Integer>[] adjList;
    static int[] dfs_low, dfs_num, parent;
    static int V, counter, root, rootChildren;
    static boolean[] artPoints;
    static ArrayList<Type> ans;
    static void findArtPointsAndBridges()
    {
	for(int i = 0; i < V; ++i)
	    if(dfs_num[i] == 0)
	    {
		root = i;
		rootChildren = 0;
		dfs(i);
		if(rootChildren <= 1)		
		    artPoints[i] = false;
	    }
    }

    static void dfs(int u)
    {
	dfs_num[u] = dfs_low[u] = ++counter;
	for(int v: adjList[u])
	    if(dfs_num[v] == 0)
	    {
		parent[v] = u;
		if(u == root)
		    ++rootChildren;
		dfs(v);
		if(dfs_low[v] >= dfs_num[u])
		    artPoints[u] = true;
		if(dfs_low[v] > dfs_num[u]){
		    ans.add(new Type(Math.min(u,v),Math.max(u, v)));
		}
		dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
	    }
	    else
		if(parent[u] != v)
		    dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
    }


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    String line = bf.nextLine();
	    if(line.length()==0)
		continue;
	    StringTokenizer st = new StringTokenizer(line);
	    V = Integer.parseInt(st.nextToken());
	    if(V==0)
	    {
		out.print("0 critical links\n\n");
		continue;
	    }
	    adjList = new ArrayList[V];
	    for (int i = 0; i < V; i++)
		adjList[i] = new ArrayList<Integer>();
	    dfs_low = new int[V];
	    dfs_num = new int[V];
	    parent = new int[V];
	    counter = 0;
	    artPoints = new boolean[V];
	    ans = new ArrayList<Type>();
	    for (int i = 0; i < V; i++)
	    {
		StringTokenizer tk = new StringTokenizer(bf.nextLine());
		int u = Integer.parseInt(tk.nextToken());
		line = tk.nextToken();
		int size = Integer.parseInt(line.substring(1, line.length()-1));
		for (int j = 0; j < size; j++)
		{
		    int v = Integer.parseInt(tk.nextToken());
		    if(!adjList[u].contains(v))
			adjList[u].add(v);
		    if(!adjList[v].contains(u))
			adjList[v].add(u);    
		}
	    }
	    findArtPointsAndBridges();
	    Collections.sort(ans);
	    out.println(ans.size() + " critical links");
	    for (int i = 0; i < ans.size(); i++)
	    {
		out.println(ans.get(i));
	    }
	    out.println();
	    
	}
	out.flush();
	out.close();
    }
    static class Type implements Comparable<Type>{
	int u; int v;
	public Type(int u, int v){
	    this.u = u;
	    this.v = v;
	}
	@Override
	public int compareTo(Type o)
	{
	    if(u == o.u)
		return v - o.v;
	    return u - o.u;
	}
	public String toString(){
	    return u + " - " + v;
	}
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
