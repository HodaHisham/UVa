package GEOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FactoryRobot10876 {
    
    static final double EPS = 1e-9;

    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	int w = 1000;
	for (int i = 1; i <= TC; i++)
	{
	    int n = bf.nextInt();
	    Circle[] obs = new Circle[n];
	    for (int j = 0; j < n; j++)
	    {
		obs[j] = new Circle(bf.nextInt(), bf.nextInt(),bf.nextInt());
	    }
	    double ans = 0;
	    double lo = 0;
	    double hi = 1000;
	    while(Math.abs(hi-lo) > EPS){
		double mid = (hi + lo);
		UnionFind uf = new UnionFind(n+4);
		for (int j = 0; j < obs.length; j++)
		{
		    if(w - obs[j].y - obs[j].r + EPS < mid)
			uf.unionSet(n, j);
		    if(obs[j].y - obs[j].r + EPS < mid )
			uf.unionSet(n+1, j);
		    if(w - obs[j].x - obs[j].r + EPS < mid )
			uf.unionSet(n+2, j);
		    if(obs[j].x - obs[j].r + EPS < mid )
			uf.unionSet(n+3, j);
		    for (int k = j+1; k < obs.length; k++)
		    {
			if(obs[k].dist(obs[j]) + EPS < mid)
			    uf.unionSet(j, k);
		    }
		}
		boolean flag = false;
		for (int j = 0; j < 4; j++)
		    for (int k = j+1; k < 4; k++)
			if(uf.isSameSet(n+j, n+k))
			{
			    flag = true;
			    break;
			}
		if(flag){
		    hi = mid/2;
		}
		else {
		    lo = mid/2;
		    ans = mid/2;
		}
	    }
	    out.printf("%.3f\n",ans);
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
    static class Circle{


	int x, y, r;                  

	Circle(int a, int b, int c) { x = a; y = b; r = c; } 

	public double dist(Circle p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)) - r - p.r; }

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
