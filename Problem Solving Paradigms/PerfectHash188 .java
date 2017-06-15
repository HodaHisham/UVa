package acm;
import java.io.*;
import java.util.*;
public class perfectHash {
   
   public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		while(s!= null){
			System.out.println(s);
			ArrayList<Integer>w= new ArrayList<Integer>();
			StringTokenizer st  = new StringTokenizer(s);
			int c = 1;
			while(st.hasMoreTokens()){
				String word=st.nextToken();
				int k= 0;
				for (int i = word.length()-1,j=0; i>=0; i--,j+=5) {
					k+= ( (int)(word.charAt(i)-96) << j);
				}
				w.add(k);
			}
		    int  n =w.size();
			while(true){
				int conflict =0;
					for (int j = 0; j < n; j++) {
						
						for (int k = j+1; k < n; k++) {
							if(j!= k && (int) (c/w.get(j))%n == (int) (c/w.get(k))%n)
								conflict = Math.max(conflict, Math.min(((int) (c/w.get(j))+1) * w.get(j), ((int) (c/w.get(k))+1) * w.get(k)));
						}
				    }
					
					if(conflict==0)
					  break;
					c = conflict;
			}
			System.out.println(c+ "\n");
			s= bf.readLine();
		}
	}
}
