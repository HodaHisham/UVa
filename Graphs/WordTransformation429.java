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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WordTransformation429 {

    static ArrayList<Integer> [] adjList;
    static int[] visited;

    static void bfs(int s, int t)
    {
	Queue<Integer> q = new LinkedList<Integer>();
	q.add(s);
	visited[s] = 0;
	while(!q.isEmpty())
	{
	    int u = q.remove();
	    for(int v: adjList[u])
		if(visited[v] == -1)
		{
		    visited[v] = visited[u] + 1;
		    q.add(v);
		}
	}
    }


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	while(n-->0){
	    HashMap<String, Integer> map = new HashMap<String,Integer>();
	    int count = 0;
	    ArrayList<String> str = new ArrayList<String>();
	    while(true){
		String inp = bf.next();
		if(inp.equals("*"))
		    break;
		str.add(inp);
		map.put(inp, count++);
	    }

	    adjList = new ArrayList[count];
	    for (int i = 0; i < adjList.length; i++)
		adjList[i] = new ArrayList<Integer>();
	    for (int i = 0; i < count; i++)
	    {
		for (int j = i+1; j < count; j++)
		{
		    if(str.get(i).length() != str.get(j).length())
			continue;
		    int tmp = 0;
		    for (int k = 0; k < str.get(i).length(); k++)
		    {
			if(str.get(i).charAt(k) != str.get(j).charAt(k))
			    tmp++;
		    }
		    if(tmp == 1){
			adjList[i].add(j);
			adjList[j].add(i);
		    }
		}
	    }
	    while(true){
		String inp = bf.nextLine();
		if(inp == null || inp.isEmpty())
		    break;
		StringTokenizer st = new StringTokenizer(inp);
		String i = st.nextToken(), t = st.nextToken();
		visited = new int[count];
		Arrays.fill(visited, -1);
		bfs(map.get(i),map.get(t));
		out.println(i + " " + t + " " + visited[map.get(t)]);
	    }
	    if(n > 0)
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
