package acm;
import java.io.*;
import java.util.*;
public class ShortStory12482 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	String s = bf.readLine();
    	while(s!= null){
    		StringTokenizer st  = new StringTokenizer(s);
        	int n = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	s= bf.readLine();
    		double lines =1;
    		for(int i = c; i<s.length();i+=c){
    			int j =i;
    			while(s.charAt(j)!= ' ')
    				j--;
    			i=j+1;
    			lines++;
    		}
    		System.out.println((int)(Math.ceil(lines/l)));
    		s= bf.readLine();
    	}
    	
	}

}

