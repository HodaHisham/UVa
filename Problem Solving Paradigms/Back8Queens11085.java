package acm;
import java.io.*;
import java.util.*;
public class back8Queens {
  static int[]rows;
  static int [] input;
  static int minI;
  //static int a,b;
  static boolean []ld;
  static boolean[]rd;
  static boolean [] rw;
  static int ans;
  public static  void backtrack(int c) {
	  if (c == 8) { 
		  ans++;
		  int min = 0;
		  for(int i = 0; i<8;i++){
			  if(input[i] != rows[i] )
				  min++;
		  }
		 minI=  Math.min(min, minI); 
		 return; 
	  } // a solution 
	  for (int r = 0; r < 8; r++) // try all possible row
	    if (!rw[r] && !ld[r - c + 7] && !rd[r + c]) { 
	    	rw[r] = true; // flag off 
	    	ld[r - c + 7]= true;
	    	rd[r + c]= true;
	    	rows[r]= c;
	    backtrack(c + 1);
	      rw[r] =  false; // restore
	      ld[r - c + 7]= false;
	      rd[r + c] = false;
	      rows[r]=0;
	  }
  }
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int count =1;
		while(s!= null){
		  StringTokenizer st  = new StringTokenizer(s);
		  input = new int[8];
		  rows  = new int[8];
		  ld = new boolean[15];
		  rd = new boolean[15];
		  rw =new boolean[15];
		  minI= 7;
    	  for(int i = 0 ;i<8;i++)
    		  input[i]= Integer.parseInt(st.nextToken())-1;
    	  Arrays.fill(rows, -1);
		  backtrack(0);
		 // System.out.println(ans);
		System.out.printf("Case %d: %d\n",count++, minI);
		  s= bf.readLine();
		}
	}

}
