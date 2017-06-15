package DataStructures;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class OneEndian594 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = bf.readLine();
		while(s != null && !s.isEmpty()){
			StringTokenizer st  = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
//			BitSet b = new BitSet();
			int rev = Integer.reverseBytes(n);
			//int i=0;
			//for( i= 0 ; (1<<i)<n; i++);
			//for(int j = 0;j<i;j++){
			//	b.set(i-1-j, (1<<j)!=0);
			//}
			 
			out.println(n + " converts to "+ rev);
			s =  bf.readLine();
		}
		out.flush();
		out.close();
	}
}
