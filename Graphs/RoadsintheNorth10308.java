package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RoadsintheNorth10308 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready())
	{
	    ArrayList<Edge> [] adjList = new ArrayList[10000];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<>();
	    }
	    while(true){
		String s = bf.nextLine();
		if(s == null || s.isEmpty())
		    break;
		StringTokenizer st = new StringTokenizer(s);
		int u = Integer.parseInt(st.nextToken())-1,
			v = Integer.parseInt(st.nextToken())-1,
			w = Integer.parseInt(st.nextToken());
		adjList[u].add(new Edge(v, w));
		adjList[v].add(new Edge(u, w));
	    }
	    int [] vis = new int[10000];
	    Arrays.fill(vis, -1);
	    Queue<Integer> q = new LinkedList<>();
	    for (int i = 0; i < adjList.length; i++)
	    {
		if(adjList[i].size() > 0){
		    q.add(i);
		    vis[i] = 0;
		    break;
		}
	    }
	    int r = 0;
	    while(!q.isEmpty())
	    {
		int u = q.poll();
		for(Edge e:adjList[u])
		{
		    if(vis[e.v] == -1){
			vis[e.v] = vis[u]+e.w;
			q.add(e.v);
			if(vis[e.v] > vis[r])
			    r = e.v;
		    }
		}
	    }
	    Arrays.fill(vis, -1);
	    q = new LinkedList<>();
	    q.add(r);
	    vis[r] = 0;
	    r = 0;
	    while(!q.isEmpty())
	    {
		int u = q.poll();
		for(Edge e:adjList[u])
		{
		    if(vis[e.v] == -1){
			vis[e.v] = vis[u]+e.w;
			q.add(e.v);
			if(vis[e.v] > vis[r])
			    r = e.v;
		    }
		}
	    }
	    out.println(vis[r]);
	}
	out.flush();
	out.close();
    }
    static class Edge{
	int v,w;
	public Edge(int a, int b){
	    v = a; w = b;
	}
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