package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;


public class HowManyDependencies10926 {
    static ArrayList<Integer> adjList[];
    static Stack<Integer>stack;
    static boolean visited [];
    public static void dfs(int u){
	visited[u]= true;
	for(int v: adjList[u]){
	    if(!visited[v])
		dfs(v);
	}
	stack.push(u);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    int [] deg = new int[n];
	    adjList = new ArrayList[n];
	    visited = new boolean[n];
	    stack = new Stack<Integer>();
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < n; i++)
	    {
		int t = bf.nextInt();
		deg[i] = t;
		while(t-->0){
		    int v = bf.nextInt()-1;
		    adjList[v].add(i);
		}
	    }
	    int max = -1;
	    for (int i = 0; i < deg.length; i++)
	    {
		if(deg[i] == 0 && !visited[i]){
		    dfs(i);
		    if(max == -1)
			max = i;
		}
	    }
//	    out.println(Arrays.toString(deg));
	    HashSet<Integer>dep[] = new HashSet[n];
	    for (int i = 0; i < dep.length; i++)
	    {
		dep[i] = new HashSet<Integer>();
	    }
	    while(!stack.isEmpty()){
		int u = stack.pop();
//		out.println(u);
		for (int v: adjList[u])
		{
		    dep[v].addAll(dep[u]);
		    dep[v].add(u);
		}
		if(dep[u].size() > dep[max].size() || dep[u].size() == dep[max].size() && u < max){
		    max = u;
		}

	    }
//	    for (int i = 0; i < dep.length; i++)
//	    {
//		out.print(dep[i].size());
//	    }
	    out.println(max+1);
//	    out.println();
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
	{    br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
    }
}

