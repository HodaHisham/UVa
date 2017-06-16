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

public class ProjectScheduling452 {
    static ArrayList<Integer> adjList[];
    static Queue<Integer>stack;
    static boolean visited [];
    static int seen [];
    public static void dfs(int u){
	visited[u]= true;
	for(int v: adjList[u]){
	    if(!visited[v]){
		dfs(v);
	    }
	}
	stack.add(u);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	bf.nextLine();
	while(TC-- > 0){
	    String s = "";
	    ArrayList<StringTokenizer> inp = new ArrayList<StringTokenizer>();
	    while((s = bf.nextLine()) != null && !s.isEmpty()){
		inp.add(new StringTokenizer(s));
	    }
	    int [] deg = new int[26];
	    adjList = new ArrayList[26];
	    visited = new boolean[26];
	    stack = new LinkedList<Integer>();
	    seen = new int[26];
	    Arrays.fill(seen, -1);
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (StringTokenizer st : inp)
	    {
		int u = st.nextToken().charAt(0)-'A';
		int cost = Integer.parseInt(st.nextToken());
		seen[u] = cost;
		if(!st.hasMoreTokens())
		    continue;
		String tmp = st.nextToken();
		for (int i = 0; i < tmp.length(); i++)
		{
		    int v = tmp.charAt(i)-'A';
		    adjList[v].add(u);
		    deg[u]++;
		}
	    }
	    for (int i = 0; i < deg.length; i++)
	    {
		if(deg[i] == 0 && seen[i] != -1)
		    dfs(i);
	    }
	    int [] dp = new int[26];
	    while(!stack.isEmpty())
	    {
		int i = stack.poll();
		for(int v: adjList[i])
		    dp[i] = Math.max(dp[i], dp[v]);
		dp[i] += seen[i];
//		out.println((char)(i+'A') + " " + dp[i]);
	    }
	    int ans = 0;
	    for (int i = 0; i < dp.length; i++)
	    {
		if(seen[i] != -1 && deg[i] == 0)
		    ans = Math.max(ans, dp[i]);
	    }
	    out.println(ans);
	    if(TC > 0)
		out.println();
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
