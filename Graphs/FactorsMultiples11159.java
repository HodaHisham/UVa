package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FactorsMultiples11159 {
    static int V, n, m, match[];	
    static ArrayList<Integer>[] adjList;
    static boolean[] vis;
    static int go()
    {
	int matches = 0;
	match = new int[m];
	Arrays.fill(match, -1);
	for(int i = 0; i < n; ++i)
	{
	    vis = new boolean[n];
	    matches += aug(i);
	}
	return matches;
    }

    static int aug(int u)	
    {
	vis[u] = true;
	for(int v : adjList[u])
	    if(match[v] == -1 || !vis[match[v]] && aug(match[v]) == 1)
	    {
		match[v] = u;
		return 1;
	    }
	return 0;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	for(int c = 1; c <= TC; c++){
	    n = bf.nextInt();
	    int[] a = new int[n];
	    adjList = new ArrayList[n];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < n; i++)
	    {
		a[i] = bf.nextInt();
	    }
	    m = bf.nextInt();
	    for (int j = 0; j < m; j++)
	    {
		int b = bf.nextInt();
		for (int i = 0; i < a.length; i++)
		{
		    if(a[i] != 0 && b % a[i] == 0 || a[i] == 0 && b == 0){
			adjList[i].add(j);
		    }
		}
	    }
	    out.println("Case " + c + ": " + go());
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

