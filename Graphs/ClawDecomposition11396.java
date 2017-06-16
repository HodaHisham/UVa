package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

 public class ClawDecomposition11396 {
    static int V, color[];
    static ArrayList<Integer> adjList[];
    public static boolean bipartiteCheck(int u){
	for (int v:  adjList[u])
	{
	    if(color[v] == -1)
	    {
		color[v] = 1 ^ color[u];
		if(!bipartiteCheck(v))
		    return false;
	    }
	    else if(color[u] == color[v])
		return false;
	}
	return true;
    }
    public static void main(String[] args) throws Exception {
	PrintWriter out = new PrintWriter(System.out);
	Scanner sc = new Scanner(System.in);
	while(true){
	    V = sc.nextInt();
	    if(V == 0)
		break;
	    adjList = new ArrayList[V];
	    color = new int[V];
	    Arrays.fill(color, -1);
	    for (int i = 0; i < V; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    while(true){
		int u = sc.nextInt();
		int v = sc.nextInt();
		if(u == 0 && v==0)
		    break;
		u--; v--;
		adjList[u].add(v);
		adjList[v].add(u);
	    }
	    boolean possible = true; 
	    for (int i = 0; i < V && possible; i++)
	    {
		if(color[i] == -1)
		    possible &= bipartiteCheck(i);
	    }
	    out.println(possible? "YES":"NO");
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
