package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class OrderingTasks10305 {
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
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		while(!(n==0 && m==0) ){
			adjList = new ArrayList[n+1];
			stack = new Stack<Integer>();
			for (int i = 0; i < n+1; i++) {
				adjList[i]  =new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
			}
			visited = new boolean[n+1];
			Arrays.fill(visited, false);
			for (int i = 1; i <=n; i++) {
				if(!visited[i])
					dfs(i);
			}
			while(!stack.isEmpty())
				if(stack.size()!=1)
					out.print(stack.pop()+ " ");
				else
					out.print(stack.pop());
			out.println();
			st = new StringTokenizer(bf.readLine());
			 n = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());
		}
		out.flush();
		out.close();
	}
}
