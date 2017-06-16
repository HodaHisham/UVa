
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

public class ComeGo11838 {

    static ArrayList<Integer>[] adjList;
    static int V, counter, SCC, dfs_num[], dfs_low[];
    static boolean[] inSCC;
    static Stack<Integer> stack;


    static void tarjanSCC()	 	//O(V + E)
    {
	for(int i = 0; i < V; ++i)
	    if(dfs_num[i] == 0)
		tarjanSCC(i);
    }

    static void tarjanSCC(int u)
    {
	dfs_num[u] = dfs_low[u] = ++counter;
	stack.push(u);

	for(int v: adjList[u])
	{
	    if(dfs_num[v] == 0)
		tarjanSCC(v);
	    if(!inSCC[v])
		dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
	}
	if(dfs_num[u] == dfs_low[u])
	{
	    //SCC found
	    SCC++;
	    while(true)
	    {
		int v = stack.pop();
		inSCC[v] = true;
		if(v == u)
		    break;
	    }
	}	
    }	
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    V = bf.nextInt(); int m = bf.nextInt();
	    if(V == 0 && m == 0)
		break;
	    counter = SCC = 0;
	    dfs_low = new int[V];
	    dfs_num = new int[V];
	    inSCC = new boolean[V];
	    stack = new Stack<Integer>();
	    adjList = new ArrayList[V];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < m; i++)
	    {
		int v = bf.nextInt()-1, w = bf.nextInt()-1, p = bf.nextInt();
		adjList[v].add(w);
		if(p == 2)
		    adjList[w].add(v);
	    }
	    tarjanSCC();
	    out.println(SCC==1?1:0);
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
