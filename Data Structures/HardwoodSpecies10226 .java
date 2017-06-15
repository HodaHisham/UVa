package acm;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.*;
import java.util.*;
  
public class hardwoodSpecies {
  
	public static void main(String[] args) throws java.lang.Exception{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st  = new StringTokenizer(bf.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	bf.readLine();
    	
    	while(n-->0){
    		SortedMap<String, Integer> h = 
    			    new TreeMap<String, Integer>(new Comparator<String>()
    			    {
    			        public int compare(String o1, String o2)
    			        {
    			            return o1.compareTo(o2);
    			        } 
    			});
    		//HashMap <Integer,String> t = new HashMap<Integer,String>();
    		String s = bf.readLine();
    		int i = 0;
    		while(s!= null){
    		 if(h.containsKey(s)){
    			//t.put(i++, s);
    			h.put(s, h.get(s)+1);
    		 }
    		 else{
    			//t.put(i++, s);
    		    h.put(s, 0);
    		 }
    		 //Collections.sort(h);
       		 s= bf.readLine();
    	    } 
    	    for(int i1 = 0;i1<n;i1++)
		     	System.out.printf("%s ", h.get(i1)/h.size());
	        }
            if(n>0) bf.readLine();
      }
}