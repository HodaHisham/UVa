package Misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class DyingTree11474 {
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-- > 0)
	{
	    int n = bf.nextInt();
	    int m = bf.nextInt();
	    int k = bf.nextInt();
	    int d = bf.nextInt();
	    Point[]doc = new Point[m];
	    for (int i = 0; i < doc.length; i++)
	    {
		doc[i] = new Point(bf.nextInt(), bf.nextInt());
	    }
	    Point[][] bran = new Point[n][];
	    HashSet<Integer> set = new HashSet<Integer>();
	    for (int i = 0; i < n; i++)
	    {
		int b = bf.nextInt();
		bran[i] = new Point[b];
		for (int j = 0; j < b; j++)
		{
		    bran[i][j] = new Point(bf.nextInt(), bf.nextInt());
		    if(!set.contains(i)){
			for (int c = 0; c < doc.length; c++)
			{
			    if(bran[i][j].dist(doc[c]) <= d){
				set.add(i);
				break;
			    }
			}
		    }
		}
	    }
	    UnionFind uf = new UnionFind(n);
	    for (int i = 0; i < bran.length; i++)
	    {
		for (int j = 0; j < bran[i].length; j++)
		{
		    for (int j2 = 0; j2 < bran.length; j2++)
		    {
			for (int l = 0; l < bran[j2].length; l++)
			{
			    if(bran[i][j].dist(bran[j2][l]) <= k){
				uf.unionSet(i, j2);
				break;
			    }
			}
		    }
		}
	    }
	    boolean flag = false;
	    for (Iterator<Integer> i = set.iterator(); i.hasNext();)
	    {
		if(uf.isSameSet(i.next(), 0)){
		    flag = true;
		    break;
		}
	    }
	    out.println(flag?"Tree can be saved :)":"Tree can't be saved :(");
	}
	out.flush();
	out.close();
    }
    static class Point implements Comparable<Point>{

	static final double EPS = 1e-9;

	int x, y;                  

	Point(int a, int b) { x = a; y = b; }  

	public int compareTo(Point p)
	{
	    if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
	    if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
	    return 0;
	}

	public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }

	static double sq(double x) { return x * x; }

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

	public void unionSet(int i, int j) 
	{ 
		if (isSameSet(i, j)) 
			return;
		numSets--; 
		int x = findSet(i), y = findSet(j);
		if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
		else
		{	p[x] = y; setSize[y] += setSize[x];
			if(rank[x] == rank[y]) rank[y]++; 
		} 
	}

	public int numDisjointSets() { return numSets; }

	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
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
