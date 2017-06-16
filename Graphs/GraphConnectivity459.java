package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GraphConnectivity459 {
    static ArrayList<Integer> adjList [] ;
    static boolean visited[];
    public static void dfs(int u){
	visited[u] =  true;
	for (int v: adjList[u]) {
	    if(!visited[v]){
		visited[v] = true;
		dfs(v);
	    }
	}
    }
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	bf.readLine();
	while(n-->0){
	    st = new StringTokenizer(bf.readLine());
	    int nodes = st.nextToken().charAt(0)-'A'+1;
	    adjList = new ArrayList[nodes];
	    for (int i = 0; i < nodes; i++) {
		adjList[i] = new ArrayList<Integer>();
	    }
	    String s = bf.readLine();
	    while(s!= null && !s.isEmpty()){
		st = new StringTokenizer(s);
		String str = st.nextToken();
		int u = str.charAt(0)-'A';
		int v= str.charAt(1)-'A';
		//System.out.println(nodes + " "+u + " " + v);
		adjList[u].add(v);
		adjList[v].add(u);
		s = bf.readLine();
	    }
	    int count = 0;
	    visited = new boolean[nodes];
	    for (int i = 0; i < nodes; i++) {

		if(!visited[i]){
		    dfs(i);
		    count++;
		}
	    }
	    out.println(count);
	    if(n>0) out.println();
	}
	out.flush();
	out.close();
    }
}
