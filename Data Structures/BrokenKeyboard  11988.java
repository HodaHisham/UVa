package acm;
import java.io.*;
import java.util.*;
public class brokenKeyboard {

	public static void main(String[] args) throws java.lang.Exception{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	String s = bf.readLine();
    	while(s!= null){
    		LinkedList<String> l  = new LinkedList<String>();
    		//LinkedList<String> l2  = new LinkedList<String>();
            boolean front = false;
            String start = "";
            l.add(start);
    		for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
    			if(c != '[' && (c != ']')){
					if(!front)
						l.addLast(""+ c);
					else 
						start += c;
						//l2.add(s.charAt(i));
					
    			}
    			else {if (c == '[' ){
    				if(!start.equals("")) {
    				  l.addFirst(start);
    				     start = "";
    				}
    				//l2 = new LinkedList<Character>();
    				     front = true;
    		          }
    			      else {
    			    	  if(!start.equals("")) {    
    			    	    l.addFirst(start);
     				         start = "";
    			    	  }
    			    	  front = false;
    			    	  }
    			     }
			}
    		l.addFirst(start);
    		for (int i = 0; i < l.size(); i++) 
    			System.out.print(l.get(i));
    		System.out.println();
    		s= bf.readLine();
    	}

	}

}
