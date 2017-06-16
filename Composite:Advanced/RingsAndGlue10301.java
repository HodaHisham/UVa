package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class RingsAndGlue10301 {
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
    static ArrayList<Integer>adjList[];
    //static boolean [] visited;
    // static int num;
    static final int EPS = (int)(1e-6);
    static class Circle{
	double x;
	double y;
	double rad;
	int id;
	public Circle(double m1,double m2,double m3,int n){
	    x = m1;
	    y = m2;
	    rad = m3;
	    id = n;
	}

    }

    /** public static void dfs(int u)			
    {

	visited[u] = true;
	num++;
	for(Circle v: adjList[u])
	    if(!visited[v.id])
		dfs(v.id);
    }**/
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    if(n== -1)
		break;
	    adjList = new ArrayList[n];
	    UnionFind u = new UnionFind(n);
	    TreeMap<Integer,Circle> tree = new TreeMap<Integer,Circle>();
	    for (int i = 0; i < n ; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < n; i++)
	    {
		double x = bf.nextDouble();
		double y = bf.nextDouble();
		double rad = bf.nextDouble();
		tree.put(i, new Circle(x,y,rad,i));
	    }
	    for (int i = 0; i < n; i++)
	    {
		Circle cir = tree.get(i);
		for (int j = i+1; j < adjList.length; j++)
		{
		    Circle c = tree.get(j);
		    if((cir.x-c.x)*(cir.x-c.x)+(cir.y-c.y)*(cir.y-c.y) + EPS < (c.rad+cir.rad)*(c.rad+cir.rad) && 
			    (cir.x-c.x)*(cir.x-c.x)+(cir.y-c.y)*(cir.y-c.y) > (c.rad-cir.rad)*(c.rad-cir.rad) + EPS){
			adjList[j].add(i);
			adjList[i].add(j);
			//out.print(cir.x+" "+cir.y + " " + c.x+ " "+c.y + "  ");
			u.unionSet(i, j);
		    }
		}
	    }
	    //out.println();
	    int res = 0;
	    for (int i = 0; i < n; i++)
	    {
		res = Math.max(res, u.sizeOfSet(i));
	    }
	    if(res == 1)
		out.println("The largest component contains 1 ring.");
	    else
		out.println("The largest component contains "+ res +" rings.");

	}
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
