package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 public class SplittingNumbers11933 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		while(n !=0 ){
			//System.out.println(Integer.toBinaryString(n));
			int a= 0;
			int b= 0; 
			int count = 0;
			int s = Integer.bitCount(n);
			for (int i = 0; count < s; i++) {
				if((n & (1<<i))!= 0) {
					count++;
					if((count & 1) == 0)//even
						b|= (1<<i);
					else a|= (1<<i);
				}
				//System.out.println(count+ " " + a + " "+ b);
			}
			System.out.println(a + " " + b);
			st = new StringTokenizer(bf.readLine());
		    n = Integer.parseInt(st.nextToken());
		}
		//out.flush();
		//out.close();
	}
}
