package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

 class Main {
	static int[][] grid;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		while(t-->0 ){
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			grid = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean flag = true;
			int u = 0, v = 0;
			boolean[][] adjMat = new boolean[n][n];
			for (int i = 0; i < m && flag; i++) {
				int count = 0;
				for (int j = 0; j < n && flag; j++) {
					if(grid[j][i] ==1){
						count++;
						if(count == 1)
							u = j;
						else if(count ==2)
							v= j;
						else if(count>2)
							flag = false;
					}
				} 
				if(!flag || count != 2)
				{
					flag = false;
					break;
				}
				if(count == 2 )
					if (adjMat[u][v])
					{
						flag = false;
						break;
					}
					else 
						adjMat[u][v] = adjMat[v][u]= true;
			}
			if(flag)
				out.println("Yes");
			else 
				out.println("No");

		}
		out.flush();
		out.close();
	}
}
