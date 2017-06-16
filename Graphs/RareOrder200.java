package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RareOrder200 {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static boolean[] deg2;
    static int V;
    
    static ArrayList<Integer> sortedArray;
    static void toposortBFS()
    {
	int[] p = new int[V];
	sortedArray = new ArrayList<Integer>(V);
	for(int i = 0; i < V; ++i)
	    for(int v: adjList[i])
		++p[v];
	PriorityQueue<Integer> roots = new PriorityQueue<Integer>();	//PriorityQueue for smallest lexiographical sorting

	for(int i = 0; i < V; ++i)
	    if(p[i] == 0 && deg2[i])
		roots.add(i);
	while(!roots.isEmpty())
	{
	    int u = roots.remove();
	    sortedArray.add(u);
	    for(int v: adjList[u])
		if(--p[v] == 0)
		    roots.add(v);
	}

	//if p contains non-zero values -> failure, not a DAG!
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    ArrayList<char[]> inp = new ArrayList<char[]>();
	    String line = "";
	    V = 26;
	    adjList = new ArrayList[26];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    while(!(line = bf.next()).equals("#")){
		inp.add(line.toCharArray());
	    }
	    deg2 = new boolean[V];
//	    boolean [] deg = new boolean[V];
	    for (int i = 0; i < inp.size(); i++)
	    {
		for (int j = i+1; j < inp.size(); j++)
		{
		    int min = Math.min(inp.get(i).length, inp.get(j).length);
		    for (int k = 0; k < min; k++)
		    {
			char a = inp.get(i)[k], b = inp.get(j)[k];
			deg2[a-'A'] = true;
			deg2[b-'A'] = true;
			if(a != b){
			    if(!adjList[a-'A'].contains(b-'A'))
				adjList[a-'A'].add(b-'A');
//			    deg[b-'A'] = true;
			    break;
			}
		    }
		}
	    }
	    visited = new boolean[V];
	    toposortBFS();
	    for(int v:sortedArray){
		out.print((char)(v+'A'));
	    }
	    out.println();
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
