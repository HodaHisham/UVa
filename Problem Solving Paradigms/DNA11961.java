package acm;
import java.io.*;
import java.util.*;
public class DNA {
   static char[] c= {'A','C','G','T'};
   static char [] s ;
   static int n;
   static int p;
   static char[] input;
   static ArrayList <String> result ;
   public static void backtrack(int ind,int trans){
	  if(trans>p) 
		  return;
	  if(ind == n){
		   if(trans<=p){
				 String sb = new String(s);
				 //System.out.println(sb);
		    	//if(!result.contains(sb))
		    		 result.add(sb);
		    }
		  return;
	  }
	  backtrack(ind+1, (input[ind]==c[0]? trans: trans +1));
	  for( int j=1 ; j<=3;j++){
            if((input[ind]==c[j]? trans: trans +1)<= p ){
        	      s[ind] = c[j];
        	      //if(!result.contains(new String(s))){
        	    	  //result.add(new String(s));
        	       backtrack(ind+1, input[ind]==c[j]? trans: trans +1);
        	       s[ind] = 'A';
            }
          
   	   }
	  
	   /**if(ind == n){
	   if(trans<=p){
			 String sb = new String(s);
			 //System.out.println(sb);
	    	if(!result.contains(sb))
	    		 result.add(sb);
	    	//}
	   //return;
	   }**/
	  
    }
	public static void main(String[] args)throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
    	int k = Integer.parseInt(st.nextToken());
        while(k-->0){
        	 st = new StringTokenizer(bf.readLine());
        	 n = Integer.parseInt(st.nextToken());
        	 p = Integer.parseInt(st.nextToken());
        	 input = bf.readLine().toCharArray();
        	 s = new char[n];
        	 Arrays.fill(s, 'A');
        	result = new ArrayList<String>();
        	backtrack(0, 0);
        	System.out.println(result.size());
        	//Collections.sort(result);
        	for (int i = 0; i < result.size(); i++) 
        	   System.out.println(result.get(i));
        }
	}

}
