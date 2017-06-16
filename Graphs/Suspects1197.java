package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Suspects1197{ 
    static int ans;
    static boolean[] visited;
    static ArrayList<Integer> adjList [] ;
    public static void dfs(int u){
	visited[u] = true;
	for(int v : adjList[u])
	    if(!visited[v])
	    {
		ans++;
		dfs(v);
	    }
    }
    public static void main(String[]args) throws IOException{
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    int m = bf.nextInt();
	    if(n == 0 && m == 0)
		break;
	    ans = 1;
	    adjList = new ArrayList[n];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for(int i = 0; i < m; i++){
		int k = bf.nextInt();
		int f = bf.nextInt();
		for(int j = 0; j < k-1; j++){
		    int num = bf.nextInt();
		    adjList[f].add(num);
		    adjList[num].add(f);
		    f = num;
		}
	    }
	    visited = new boolean[n];
	    dfs(0);
	    out.println(ans);
	}
	out.flush();
	out.close();
    }
    static class Scanner{
	BufferedReader bf;
	StringTokenizer st;
	public Scanner(InputStream s){
	    bf = new BufferedReader(new InputStreamReader(s));
	}
	public String next() throws IOException{
	    while(st == null || !st.hasMoreTokens())
		st = new StringTokenizer(bf.readLine());
	    return st.nextToken();
	}
	public String nextLine() throws IOException{
	    return bf.readLine();
	}
	public int nextInt() throws NumberFormatException, IOException{
	    return Integer.parseInt(next());
	}
	public boolean ready() throws IOException{
	    return bf.ready();
	}
    }
}