package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PlaceGuards11080 {
    static ArrayList<Integer> adjList[];
    static int[] color;
    static int b,w;
    static boolean flag;
    static void bipartitieCheck(int u)
    {
	if(color[u] == 0) w++; else b++;
	for(int v: adjList[u])
	    if(color[v] == -1)
	    {
		color[v] = 1 ^ color[u];
		bipartitieCheck(v);
	    }
	    else
		if(color[v] == color[u])
		    flag = false;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    int n = bf.nextInt(), m = bf.nextInt();
	    adjList = new ArrayList[n];
	    color = new int[n];
	    Arrays.fill(color, -1);
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < m; i++)
	    {
		int u = bf.nextInt(), v = bf.nextInt();
		adjList[u].add(v);
		adjList[v].add(u);
	    }
	    flag = true; int sum = 0;
	    for (int i = 0; i < n; i++)
	    {
		if(color[i] == -1){
		    w = 0; b = 0;
		    color[i] = 0;
		    bipartitieCheck(i);
		    sum += Math.min(Math.max(1,w), Math.max(1,b));
		}
	    }
	    out.println(flag?sum:-1);
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
