package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArcticNetwork10369 {

    public static int dist2(int x1, int y1, int x2,int y2){
	return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
    }
    static Edge[] edgeList;
    static int V,s;

    static int kruskal()		//O(E log E)
    {
	int mst = 0;
	Arrays.sort(edgeList);
	UnionFind uf = new UnionFind(V);

	for(Edge e: edgeList){
	    if(uf.numSets == s)
		break;
	    if(uf.unionSet(e.u, e.v)){
		 mst = Math.max(e.w,mst);
	    }
	}
	return mst;
    }

    static class Edge implements Comparable<Edge>
    {
	int u, v, w;

	Edge(int a, int b, int c) {	u = a; v = b; w = c; }

	public int compareTo(Edge e) { return w - e.w; }
    }

    static class UnionFind {                                              
	int[] p, rank, setSize;
	int numSets;

	public UnionFind(int N) 
	{
	    p = new int[numSets = N];
	    rank = new int[N];
	    setSize = new int[N];
	    for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
	}

	public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

	public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public boolean unionSet(int i, int j) 
	{ 
	    if (isSameSet(i, j)) 
		return false;
	    numSets--; 
	    int x = findSet(i), y = findSet(j);
	    if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
	    else
	    {	p[x] = y; setSize[y] += setSize[x];
	    if(rank[x] == rank[y]) rank[y]++; 
	    } 
	    return true;
	}

	public int numDisjointSets() { return numSets; }

	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    s = bf.nextInt(); int p = bf.nextInt();
	    V = p;
	    Edge[]inp = new Edge[p];
	    for (int i = 0; i < p;i++)
	    {
		inp[i] = new Edge(bf.nextInt(), bf.nextInt(), 0);
	    }
	    edgeList = new Edge[p*(p-1)];
	    int count = 0;
	    for (int i = 0; i < inp.length; i++)
	    {
		for (int j = i+1; j < inp.length; j++)
		{
		    edgeList[count++] = new Edge(i, j, dist2(inp[i].u,inp[i].v,inp[j].u,inp[j].v));
		}
	    }
	    edgeList = Arrays.copyOf(edgeList, count);
	    int ans = kruskal();
	    out.printf("%.2f\n", Math.sqrt(ans));
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
