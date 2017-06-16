
package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class CallingCircles247 {

    static ArrayList<Integer>[] adjList;
    static int V, counter, SCC, dfs_num[], dfs_low[];
    static int[] inSCC;
    static Stack<Integer> stack;
    static ArrayList<StringBuilder> res;
    static String [] names;
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
	    if(inSCC[v] == -1)
		dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
	}
	if(dfs_num[u] == dfs_low[u])
	{
	    //SCC found
	    SCC++;
	    StringBuilder tmp = new StringBuilder();
	    while(true)
	    {
		int v = stack.pop();
		if(tmp.length() > 0)
		    tmp.append(", ");
		tmp.append(names[v]);
		inSCC[v] = SCC;
		if(v == u)
		    break;
	    }
	    res.add(tmp);
	}	
    }	
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    V = bf.nextInt(); int m = bf.nextInt();
	    if(V == 0 && m == 0)
		break;
	    if(cases > 1)
		out.println();
	    counter = SCC = 0;
	    dfs_low = new int[V];
	    dfs_num = new int[V];
	    inSCC = new int[V];
	    Arrays.fill(inSCC,-1);
	    stack = new Stack<Integer>();
	    adjList = new ArrayList[V];
	    HashMap<String, Integer> map = new HashMap<String,Integer>();
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    int count = 0;
	    names = new String[V];
	    for (int i = 0; i < m; i++)
	    {
		String f = bf.next(), s = bf.next();
		if(!map.containsKey(f)){
		    names[count] = f;
		    map.put(f, count++);
		}
		if(!map.containsKey(s)){
		    names[count] = s;
		    map.put(s, count++);
		}
		int u = map.get(f), v = map.get(s);
		adjList[u].add(v);
	    }
	    res = new ArrayList<StringBuilder>();
	    tarjanSCC();
	    out.println("Calling circles for data set "+ cases++ +":");

	    for (int i = 0; i < res.size(); i++)
	    {
		out.println(res.get(i));
	    }
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
