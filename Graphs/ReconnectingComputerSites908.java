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


public class ReconnectingComputerSites908 {
    static ArrayList<Edge> edgeList;
    static int V;

    static int kruskal()		//O(E log E)
    {
	int mst = 0;
	Collections.sort(edgeList);
	UnionFind uf = new UnionFind(V);

	for(Edge e: edgeList)
	    if(uf.union(e.u, e.v))
		mst += e.w;
	return mst;
    }

    static class Edge implements Comparable<Edge>
    {
	int u, v, w;

	Edge(int a, int b, int c) {	u = a; v = b; w = c; }

	public int compareTo(Edge e) { return w - e.w; }
    }

    static class UnionFind {                                              
	int[] p, rank;

	UnionFind(int N) 
	{
	    p = new int[N];
	    rank = new int[N];
	    for (int i = 0; i < N; i++) 
		p[i] = i;
	}

	int findSet(int x) { return p[x] == x ? x : (p[x] = findSet(p[x])); }

	boolean union(int x, int y) 
	{ 
	    x = findSet(x);
	    y = findSet(y);
	    if(x == y)
		return false;

	    if (rank[x] > rank[y]) 
		p[y] = x;
	    else
	    {	
		p[x] = y;
		if(rank[x] == rank[y])
		    ++rank[y]; 
	    } 
	    return true;
	}
    }


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int sum = 0;
	    V = bf.nextInt();
	    for (int i = 0; i < V-1; i++)
	    {
		bf.nextInt(); bf.nextInt(); sum += bf.nextInt();
	    }
	    int k = bf.nextInt();
	    edgeList = new ArrayList<Edge>();
	    for (int i = 0; i < k; i++)
	    {
		int u = bf.nextInt()-1, v = bf.nextInt()-1, c = bf.nextInt();
		edgeList.add(new Edge(u, v, c));
		edgeList.add(new Edge(v, u, c));
	    }
	    int m = bf.nextInt();
	    for (int i = 0; i < m; i++)
	    {
		int u = bf.nextInt()-1, v = bf.nextInt()-1, c = bf.nextInt();
		edgeList.add(new Edge(u, v, c));
		edgeList.add(new Edge(v, u, c));
	    }
	    out.println(sum);
	    out.println(kruskal());	    
	    if(bf.ready())
		out.println();
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
