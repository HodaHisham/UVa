package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ManyPathsOneDestination988 { // change to eof
    static ArrayList<Integer> adjList [];
    static Stack<Integer> stack;
    static boolean [] visited;
    static void toposortDFS(int u)	//don't forget preTraversal	
    {
	visited[u] = true;

	for(int v: adjList[u])
	    if(!visited[v])			//if v is explored -> failure, not a DAG!
		toposortDFS(v);
	stack.add(u);
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(bf.ready()){
	    int n = bf.nextInt();
	    adjList = new ArrayList[n];
	    visited = new boolean[n];
	    stack = new Stack<Integer>();
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < n; i++)
	    {
		int k = bf.nextInt();
		for (int j = 0; j < k; j++)
		{
		    adjList[i].add(bf.nextInt());
		}
	    }
	    toposortDFS(0);
	    int ans = 0;
	    int [] val = new int[n];
	    val[0] = 1;
	    while(!stack.isEmpty()){
		int u = stack.pop();
		for(int v: adjList[u])
		    val[v] += val[u];
		if(adjList[u].size() == 0)
		    ans += val[u];
	    }
	    if(cases++ > 1) out.println();
	    out.println(ans);
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
