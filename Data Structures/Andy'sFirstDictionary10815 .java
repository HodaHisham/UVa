package acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class andyDictionary {
    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		ArrayList<String > ts = new ArrayList<String>();
		while(s!= null){
			String [] st = s.toLowerCase().split("[^abcdefghijklmnopqrstuvwxyz]");
			
			for (int i = 0; i < st.length; i++) {
				if(!ts.contains(st[i]) && !st[i].equals("") && !st.equals(" "))
				   ts.add(st[i]);
			}
			s = bf.readLine();
		}
		Collections.sort(ts); 
		for(int i = 0;i<ts.size();i++){
			//String str = ts.first();
			System.out.println(ts.get(i));
			//ts.remove(str);
	   }
	    
	}

}