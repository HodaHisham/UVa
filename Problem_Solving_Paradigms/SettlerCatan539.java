package PSParadigms;
import java.io.*;
import java.util.*;

public class SettlerCatan539 {
	static ArrayList<Integer>[] AdjList ;
	static int [][]vis;
	static boolean[] nodesVis;
	static int maxLength;
	public static void backtrack(int node, int max){
		//nodesVis[node] = true;
		boolean found = false;
		for(int i = 0 ;i<vis[node].length && !found;i++)
			if(vis[node][i]== 0 )//unvisited edge
				found = true;
		if(!found){
			maxLength = Math.max(maxLength, max);
			return;
		}

		for(int i = 0; i<AdjList[node].size();i++){
			int v= AdjList[node].get(i);
			//nodesVis[v]= true;
			if(vis[node][v]==0){
				vis[node][v] =vis[v][node] = 1;
				backtrack(v, max+1);
				vis[node][v] = vis[v][node] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PrintWriter out = new PrintWriter(System.out);
		while(n!= 0 || m!= 0){
			AdjList = new ArrayList[n];
			vis = new int[n][n];

			for(int i = 0;i<n;i++){
				AdjList[i]= new ArrayList<Integer>();
				Arrays.fill(vis[i], -1);
			}
			for(int i = 0; i<m;i++){
				st  = new StringTokenizer(bf.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				AdjList[node1].add(node2);
				AdjList[node2].add(node1);
				vis[node1][node2] = vis[node2][node1] = 0;
			}
			maxLength = 0;

			//nodesVis = new boolean[n];
			for (int i = 0; i < n; i++) 
				backtrack(i, 0);

			out.println(maxLength);
			st  = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		}
		out.flush();
		out.close();

	}

}


