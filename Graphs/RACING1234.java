package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RACING1234 {
    static Edge[] edgeList;
	static int n;
	
	static int kruskal()		//O(E log E)
	{
		int mst = 0;
		Arrays.sort(edgeList);
		UnionFind uf = new UnionFind(n);
		
		for(Edge e: edgeList)
			if(!uf.isSameSet(e.from, e.to))
			{
				mst += e.cost;
				uf.unionSet(e.from, e.to);
			}
		
		return mst;
	}
	
	static class Edge implements Comparable<Edge>
	{
		int from, to, cost;
		
		Edge(int a, int b, int c)
		{
			from = a; to = b; cost = c;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return e.cost - cost;
			if(from != e.from)
				return e.from - from;
			return e.to - to;
		}
	}
	
	static class UnionFind {                                              
		int[] p, rank, setSize;
		int numSets;
		
		public UnionFind(int N) 
		{
			 p = new int[N];
			 rank = new int[N];
			 setSize = new int[N];
			 numSets = N;
			 for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
		}
		
		public int findSet(int i) 
		{ 
			if (p[i] == i) return i;
			else return p[i] = findSet(p[i]);
		 }
		
		public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
		
		public void unionSet(int i, int j) 
		{ 
			 if (isSameSet(i, j)) 
				 return;
			 numSets--; 
			 int x = findSet(i), y = findSet(j);
			 // rank is used to keep the tree short
			 if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
			 else
			 {	p[x] = y; setSize[y] += setSize[x];
			 	if(rank[x] == rank[y]) rank[y]++; 
			 } 
		}
		
		public int numDisjointSets() { return numSets; }
		
		public int sizeOfSet(int i) { return setSize[findSet(i)]; }
	}
    public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int c = sc.nextInt();
	while(c-- > 0){
	     n = sc.nextInt();
            int m = sc.nextInt();
            edgeList = new Edge[m];
            int total = 0;
            for (int i = 0; i < edgeList.length; i++)
	    {
		int u = sc.nextInt()-1;
		int v = sc.nextInt()-1;
		int cost = sc.nextInt();
		edgeList[i] = new Edge(u,v,cost);
		total += cost;
	    }
            int max = kruskal();
            out.println(total - max);
	}
        int tmp = sc.nextInt(); //zero
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

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
	}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}


    }
}
