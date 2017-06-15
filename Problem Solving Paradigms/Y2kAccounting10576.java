package acm;
import java.io.*;
import java.util.*;
public class y2kAccounting {
	static int ans;
    static boolean possible;
	static int[]earn;
	static  int s,d;
   public static void backtrack(int ear, int month){
	   
	   if(month ==13){ //sol
		   if(ear>=0 ){
			   possible =true;
			   ans = Math.max(ans, ear);
		   }
	   return;
	   }
	  if(month>=5 && earn[month] +s <0 ){
		  place(s,month,true);
	    backtrack(ear+s,month+1);
	    place(s,month,false);
	  }
	  if(month>=5 && earn[month] -d <0){
		  place(-d,month,true);
	     backtrack(ear-d,month+1);
	     place(-d,month,false);
	  }
	  else if(month<5){
		  place(s,month,true);
		  backtrack(ear+s,month+1);
		  place(s,month,false);
		  place(-d,month,true);
		  backtrack(ear-d,month+1);
		  place(-d,month,false);
	   }
   }
   
   public static void place(int x, int m, boolean b){
	for(int i = m;i<m+5 && i<=12;i++){
		if(b)
	    	earn[i] += x ;
		else
			earn[i] -= x ;
	}
}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		while(str!= null){
			StringTokenizer st  = new StringTokenizer(str);
			 s = Integer.parseInt(st.nextToken());;
			 d = Integer.parseInt(st.nextToken());;
			 ans = 0;
			 possible = false;
			 earn = new int[13];
			 backtrack(0, 1);
			 if(possible)
			  System.out.println(ans);
			 else 
				 System.out.println("Deficit");
			str = bf.readLine();
		}
	}

}
