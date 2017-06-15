package Ch4;
import java.io.*; 
import java.util.*;
public class shellSort {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
    	int k = Integer.parseInt(st.nextToken());
        while(k-->0){
        	st  = new StringTokenizer(bf.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	HashMap<Integer,String> inToStr = new HashMap<Integer,String>();
        	HashMap<String,Integer> strToIn = new HashMap<String,Integer>();
        	StringBuilder old = new StringBuilder();
        	StringBuilder newS = new StringBuilder();
        	for (int i = 0; i < n; i++) {
        		String s = bf.readLine();
				inToStr.put(i, s);
				strToIn.put(s, i);
				old.append(" "+ i); 
			}
        	for (int i = 0; i < n; i++) {
        		String s = bf.readLine();
        		int ind= strToIn.get(s);
        		newS.append(" "+ ind);
			}
        	System.out.println(old + " " + newS);
        	ArrayList<Integer> arr = new ArrayList<Integer>();
        	int prev = newS.length()-1;
        	for(int i = newS.length()-2; i>=0 &&!newS.equals(old);){
        		int ind = old.indexOf("" + newS.charAt(i));
        		//if(ind i )
        	}
        	for (int i = 0; i < arr.size() ; i++) {
				System.out.println(inToStr.get(arr.get(i)));
			} 
        }
	}

}
