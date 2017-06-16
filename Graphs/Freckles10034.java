package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Freckles10034 {
    static Edge [] edgeList;
    static int V;

    static double kruskal()		//O(E log E)
    {
	double mst = 0;
	Arrays.sort(edgeList);
	UnionFind uf = new UnionFind(V);

	for(Edge e: edgeList)
	    if(uf.union(e.u, e.v)){
		mst += e.w;
	    }
	return mst;
    }
    static class Edge implements Comparable<Edge>
    {
	int u, v; double w;

	Edge(int a, int b, double c) {	u = a; v = b; w = c; }

	public int compareTo(Edge e) {
	    if(w == e.w) return 0;
	    return w > e.w?1:-1; 
	    }
	
	public String toString(){
	    return u + " "+ v + " " + w;
	}
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
	int TC = bf.nextInt();
	while(TC-->0){
	    V = bf.nextInt();
	    Point [] nodes = new Point[V];
	    for (int i = 0; i < V; i++)
		nodes[i] = new Point(bf.nextDouble(), bf.nextDouble());
	    edgeList = new Edge[V*(V-1)];
	    for (int i = 0,k = 0; i < nodes.length; i++)
	    {
		for (int j = i+1; j < nodes.length; j++)
		{
		    double tmp = Math.sqrt((nodes[i].x-nodes[j].x)*(nodes[i].x-nodes[j].x)+(nodes[i].y-nodes[j].y)*(nodes[i].y-nodes[j].y));
//		    out.println(i + " " + j + " " + tmp);
		    edgeList[k++] = new Edge(i,j,tmp);
		    edgeList[k++] = new Edge(j,i,tmp);
		}
	    }
	    out.printf("%.2f\n",kruskal());
	    if(TC > 0)
		out.println();
	}
	out.flush();
	out.close();
    }
static class Point{
    double x,y;
    public Point(double x, double y){
	this.x = x; this.y = y;
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
	
    }
}
