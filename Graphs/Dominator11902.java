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


public class Dominator11902 {
    static ArrayList<Integer> adjList[];
    static boolean [] visited;
    public static void dfs(int u, int s){
	visited[u] = true;
	for(int v: adjList[u]){
	    if(v != s && !visited[v])
		dfs(v,s);
	}
    }
    public static void main(String[] args) throws Exception { 
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	for (int k = 1; k <= TC; k++)
	{
	    int n = bf.nextInt();
	    adjList = new ArrayList[n];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < n; i++)
	    {
		for (int j = 0; j < n; j++)
		{
		    int a = bf.nextInt();
		    if(a == 1)
			adjList[i].add(j);
		}
	    }
	    visited = new boolean[n];
	    dfs(0,-1);
	    boolean [] tmp = Arrays.copyOf(visited, n);
	    boolean [][] res = new boolean[n][n];
	    for (int i = 0; i < n; i++)
	    {
		visited = new boolean[n];
		dfs(0,i);
		for (int j = 0; j < n; j++)
		{
		    if(tmp[j] && !visited[j])
			res[i][j] = true;
		}
	    }
	    out.println("Case " + k + ":");
	    for (int i = 0; i < res.length; i++)
	    {
		out.print("+");
		for (int j = 0; j < 2*n-1; j++)
		    out.print("-");
		out.println("+");
		for (int j = 0; j < res.length; j++)
		{
		    if(tmp[j] && (i == j  || i == 0))
			out.print("|Y");
		    else 
			out.print(res[i][j]?"|Y":"|N");
		}
		out.println("|");
	    }
	    out.print("+");
	    for (int j = 0; j < 2*n-1; j++)
		out.print("-");
	    out.println("+");
	}
	out.flush();
	out.close();
    }

    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{   br = new BufferedReader(fileReader);	}

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
