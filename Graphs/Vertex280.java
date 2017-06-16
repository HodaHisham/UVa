package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
public class Vertex280 {
	static ArrayList<Integer>[] adjList;
	static boolean visited[];
	public static void dfs(int u, boolean start){
		//System.out.println(u);
		if(! start)
			visited[u] = true;
		for(int v : adjList[u]){
			if(!visited[v]){
				visited[v] = true;
				dfs(v,false);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		while(n!=0 ){
			adjList = new ArrayList[n+1];
			for (int i = 1; i <= n; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			while(v!= 0 ){

				int i = Integer.parseInt(st.nextToken());
				while(i!= 0 ){
					adjList[v].add(i) ;
					i = Integer.parseInt(st.nextToken());
				}
				st = new StringTokenizer(bf.readLine());
				v = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			v = Integer.parseInt(st.nextToken());
			for (int i = 0; i < v; i++) {
				int d =Integer.parseInt(st.nextToken());
				visited = new boolean[n+1];
				Arrays.fill(visited, false);
				//System.out.println(d);
				dfs(d,true);
				ArrayList<Integer> arr  =new ArrayList<Integer>();
				for (int j =1; j <= n; j++) {
					if(!visited[j])
						arr.add(j);

				}
				out.print(arr.size());
				for (int j = 0; j < arr.size(); j++) 
					out.print(" "+arr.get(j));
				out.println();
			}
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
		}
		out.flush();
		out.close();
	}
}
