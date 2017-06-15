package GEOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fatman295 {
    static final double EPS = 1e-6;

    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	for (int i = 1; i <= TC; i++)
	{
	    bf.nextInt();
	    int w = bf.nextInt();
	    int n = bf.nextInt();
	    Point[] obs = new Point[n];
	    for (int j = 0; j < n; j++)
	    {
		obs[j] = new Point(bf.nextInt(), bf.nextInt());
	    }
	    double ans = 0;
	    double lo = 0;
	    double hi = w;
	    while(Math.abs(hi-lo) > EPS){
		double mid = (hi + lo)/2;
		UnionFind uf = new UnionFind(n+2);
		for (int j = 0; j < obs.length; j++)
		{
		    if(w - obs[j].y < mid + EPS)
			uf.unionSet(n, j);
		    if(obs[j].y < mid + EPS)
			uf.unionSet(n+1, j);
		    for (int k = j+1; k < obs.length; k++)
		    {
			if(obs[k].dist(obs[j]) < mid*mid + EPS)
			    uf.unionSet(j, k);
		    }
		}
		if(uf.isSameSet(n, n+1)){
		    hi = mid;
		}
		else {
		    lo = mid;
		    ans = mid;
		}
	    }
	    out.printf("Maximum size in test case %d is %.4f.\n",i,ans);
	}
	out.flush();
	out.close();
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
    static class Point{


	int x, y;                  

	Point(int a, int b) { x = a; y = b; } 

	public int dist(Point p) { return sq(x - p.x) + sq(y - p.y); }

	static int sq(int x) { return x * x; }
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

	public boolean ready() throws IOException {return br.ready();}
    }

}
