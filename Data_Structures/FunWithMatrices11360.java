package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FunWithMatrices11360 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= t; i++) {
			st  = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) {
				st  = new StringTokenizer(bf.readLine());
				String s = st.nextToken();
				for (int k = 0; k < n; k++) {
					matrix[j][k] = Integer.parseInt(""+ s.charAt(k));
				}
			}
			st  = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				st  = new StringTokenizer(bf.readLine());
				String s = st.nextToken();
				switch(s){
				case "row":{
					int a = Integer.parseInt(st.nextToken())-1;
					int b = Integer.parseInt(st.nextToken())-1;
					for (int k = 0; k < matrix.length; k++) {
						int tmp = matrix[a][k];
						matrix[a][k] = matrix[b][k];
						matrix[b][k]= tmp;
					}
					break;
				}
				case "col": {
					int a=  Integer.parseInt(st.nextToken())-1;
					int b = Integer.parseInt(st.nextToken())-1;
					for (int k = 0; k < matrix.length; k++) {
						int tmp = matrix[k][a];
						matrix[k][a] = matrix[k][b];
						matrix[k][b]= tmp;
					}
					break;

				}
				case "transpose": 
				{  int[][]tmp = new int[n][n];
					for (int k = 0; k < matrix.length; k++) 
						for (int l = 0; l < matrix.length; l++) 
							tmp[k][l] = matrix[l][k];
				    matrix = tmp;
					break;

				}
				case "inc":
				{
					for (int k = 0; k < matrix.length; k++) 
						for (int l = 0; l < matrix.length; l++) 
							matrix[k][l]= (matrix[k][l]+1)%10;
					break;

				}
				case "dec":
				{
					for (int k = 0; k < matrix.length; k++) 
						for (int l = 0; l < matrix.length; l++) 
							matrix[k][l]= (matrix[k][l]+9)%10;
					break;

				}
				
				}
			}
			out.println("Case #" + i);
			
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) 
					out.print(matrix[j][k]);
				
				out.println();
			}
			out.println();
		}
	//    out.println(((0-1)+10) %10);
	    out.flush();
	    out.close();
	}
}
