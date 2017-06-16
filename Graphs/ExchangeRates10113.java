package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ExchangeRates10113 {
    static ArrayList<Edge>adjList[] ;
    static boolean [] visited;
    static int x1,y1, node,t;
    public static int GCD(int a, int b)
    { 
	return b == 0 ? a : GCD(b, a % b); 
    }
    public static void dfs(int u,int x2,int y2)				//O(V + E) adjList, O(V^2) adjMat	
    {
	visited[u] = true;
	if(u == t){ 
	    x1 = x2;
	    y1 = y2;
	    return;
	}
	for(Edge v: adjList[u])
	    if(!visited[v.to]){
		int m = x2 * v.x;
		int n = y2 * v.y;
		int g = GCD(m,n);
		m /= g;
		n /= g;
		dfs(v.to,m,n);
	    }
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	String s = "";
	adjList = new ArrayList[60];
	for (int i = 0; i < adjList.length; i++)
	{
	    adjList[i] = new ArrayList<Edge>();
	}

	node = 0;
	TreeMap <String,Integer>tree = new TreeMap<String,Integer>();
	while(!( s = bf.next()).equals(".")){
	    if(s.equals("!")){
		int x = bf.nextInt();
		s = bf.next();
		bf.next();
		int y = bf.nextInt();
		String other = bf.next();
		int g = GCD(x,y);
		x /= g;
		y/= g;
		int u = 0, v = 0;
		if(tree.get(s) == null)
		{
		    u = node; 
		    tree.put(s, node++);
		}
		else 
		    u = tree.get(s);
		if(tree.get(other) == null)
		{
		    v = node; 
		    tree.put(other, node++);
		}
		else 
		    v = tree.get(other);
		adjList[u].add(new Edge(v, x,y));
		adjList[v].add(new Edge(u, y,x));

	    }
	    else if(s.equals("?")){
		s = bf.next();
		bf.next();
		String o = bf.next();
		int u = tree.get(s);
		int v = tree.get(o);
		int x2 = 0, y2 = 0;
		t = v;
		for(Edge e: adjList[u]){
		    visited = new boolean[60];
		    x2 = e.x;
		    y2 = e.y;
		    dfs(e.to,x2,y2);
		    if(visited[v]){
			out.println(x1 + " " + s + " = " + y1 + " " + o);
			break;
		    }
		}


		if(!visited[v])
		{
		    out.println("? " + s + " = " + "? " + o); 
		}
	    }
	}
	out.flush();
	out.close();
    }
    static class Edge{
	int x;
	int y;
	int to;
	public Edge(int t, int a, int b){
	    to = t;
	    x = a;
	    y = b;
	}
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
