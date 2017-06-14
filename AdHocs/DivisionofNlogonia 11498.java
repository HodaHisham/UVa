import java.io.*;
import java.util.*;
public class DivisionofNlogonia {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int k= Integer.parseInt(s1.nextToken());
    while(k != 0){
    	s1= new StringTokenizer(bf.readLine());
      int n= Integer.parseInt(s1.nextToken());
      int m= Integer.parseInt(s1.nextToken());
      for(int i = 0 ;i<k;i++){
      	s1= new StringTokenizer(bf.readLine());
      int x= Integer.parseInt(s1.nextToken());
      int y= Integer.parseInt(s1.nextToken());
      	String out = "";
      	if(y==m || x==n)
      		out = "divisa";
      	else if(x>n && y>m)
      		   out = "NE";
      		  else if(x<n && y>m)
      		  	    out ="NO" ;
      		  	    else if(x<n && y<m)
      		  	        out ="SO" ;
      		  	    else
      		  	    	out = "SE";
      	System.out.println(out);
      }
      s1= new StringTokenizer(bf.readLine());
      k= Integer.parseInt(s1.nextToken());
    }
 }
}