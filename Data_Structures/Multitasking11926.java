package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Multitasking11926 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		while(n!=0 || m!=0){
			BitSet b = new BitSet(1000000);
			boolean bool = true;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				while(x<y && bool){
					if(b.get(x)) bool =false;
					else b.set(x);
					x++;
				}
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int inter = Integer.parseInt(st.nextToken());
				for (int j = 0; x+j < 1000000; j+= inter) {
					for(int k = x+j; k<y+j && k<1000000 && bool;k++){
						if(b.get(k)) bool =false;
						else b.set(k);
					}
				}
			}
			//out.println(b.toString());
			if(bool)
				out.println("NO CONFLICT");
			else out.println("CONFLICT");
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

		}
		out.flush();
		out.close();
	}
}
