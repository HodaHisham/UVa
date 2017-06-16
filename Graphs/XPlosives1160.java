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

public class XPlosives1160 {
    static ArrayList<Edge> edgeList;
    static int V;

    static class Edge implements Comparable<Edge>{
	int u,v,w;
	public Edge(int a, int b, int c){
	    u = a; v = b; w = c; 
	}
	@Override
	public int compareTo(Edge o)
	{
	    // TODO Auto-generated method stub
	    return w - o.w;
	}

    }
    public static int kruskal(){
	Collections.sort(edgeList);
	int mst = 0;
	UnionFind uf = new UnionFind(V);
	for(Edge e: edgeList){
	    if(uf.union(e.u, e.v))
		mst++;
	}
	return mst;
    }
    static class UnionFind{
	int[] p,rank;
	public UnionFind(int N){
	    p = new int[N];
	    rank = new int[N];
	    for(int i = 0; i < N; i++)
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
	boolean flag = false;
	while(bf.ready()){
	    edgeList = new ArrayList<>();
	    while(bf.ready())
	    {
		Integer u = bf.nextInt();
		if(u == null){
		    flag = true;
		    break;
		}
		if(u == -1)
		    break;
		int v = bf.nextInt();
		edgeList.add(new Edge(u, v, 1));
		edgeList.add(new Edge(v, u, 1));
	    }
	    if(flag)
		break;
	    V = (int)1e5;
	    out.println(edgeList.size()/2 - kruskal());
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
	    while (br.ready() && (st == null || !st.hasMoreTokens()))
		st = new StringTokenizer(br.readLine());
	    return !st.hasMoreTokens()?null:st.nextToken();
	}

	public Integer nextInt() throws IOException
	{
	    String tmp = next();
	    return tmp == null?null:Integer.parseInt(tmp);
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
