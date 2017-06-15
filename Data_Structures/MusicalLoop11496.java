package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MusicalLoop11496 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		while(n!=0)
		{
			int[]peaks= new int[n+2];
			st  = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= n; i++) 
				peaks[i]= Integer.parseInt(st.nextToken());
			peaks[0]= peaks[n];
			peaks[n+1] = peaks[1];
			int count = 0;
			for (int i = 1; i <= n; i++) 
				if((peaks[i-1]<peaks[i] && peaks[i+1]<peaks[i])||(peaks[i-1]>peaks[i]&& peaks[i+1]>peaks[i]))
					count++;
			out.println(count);
			st  = new StringTokenizer(bf.readLine());
	        n = Integer.parseInt(st.nextToken());
	        
		}
		out.flush();
		out.close();
	}
}
