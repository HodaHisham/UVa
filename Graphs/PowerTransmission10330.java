package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class PowerTransmission10330 {
    static final int INF = (int)1e9;
    static int V, s, t;						//input
    static ArrayList<Integer>[] adjList;	//input
    static int[][] res;						//input
    static int[] p;

    static int edmondsKarp()
    {
	int mf = 0;
	while(true)
	{
	    Queue<Integer> q = new LinkedList<Integer>();
	    p = new int[V];
	    Arrays.fill(p, -1);
	    p[s] = s;
	    q.add(s);
	    while(!q.isEmpty())
	    {
		int u = q.remove();
		if(u == t)
		    break;
		for(int v: adjList[u])
		    if(res[u][v] > 0 && p[v] == -1)
		    {
			p[v] = u;
			q.add(v);
		    }
	    }

	    if(p[t] == -1)
		break;
	    mf += augment(t, INF);
	    //System.out.println();

	}



	return mf;
    }

    static int augment(int v, int flow)
    {
	//System.out.print(v+" ");
	if(v == s)
	    return flow;
	flow =  augment(p[v], Math.min(res[p[v]][v],flow));
	res[p[v]][v] -= flow;
	res[v][p[v]] += flow;

	return flow;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	String str = bf.nextLine();
	while(str != null && !str.isEmpty()){
	    StringTokenizer st = new StringTokenizer(str);
	    int n = Integer.parseInt(st.nextToken());
	    V = 2*n+2;
	    adjList = new ArrayList[V];
	    for (int i = 0; i < V; i++)
		adjList[i] = new ArrayList<Integer>();
	    res = new int[V][V];
	    for (int i = 1; i <= n; i++)
	    {
		int cap = bf.nextInt();
		adjList[2*i-1].add(2*i);
		//System.out.println(i+" "+n);
		res[2*i-1][2*i] = cap;
	    }
	    int m = bf.nextInt();
	    for (int i = 0; i < m; i++)
	    {
		int u = bf.nextInt();
		int v = bf.nextInt();
		int f = bf.nextInt();
		adjList[2*u].add(2*v-1);
		adjList[2*v-1].add(2*u);
		res[2*u][2*v-1] = f;
	
	    }
	    int b = bf.nextInt();
	    int d = bf.nextInt();
	    for (int i = 0; i < b; i++)
	    {
		int u = bf.nextInt();
		adjList[0].add(2*u-1);
		adjList[2*u-1].add(0);
		res[0][2*u-1] = INF;
		
	    }
	    for (int i = 0; i < d; i++)
	    {
		int u = bf.nextInt();
		adjList[2*u].add(V-1);
		adjList[V-1].add(2*u);
		res[2*u][V-1] = INF;
	    }
	    
	    s = 0;
	    t = V-1;
	    out.println(edmondsKarp());
	    str = bf.nextLine();
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
