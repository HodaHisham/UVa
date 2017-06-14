

import java.io.*;
import java.util.*;
public class SaveSetu {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int t= Integer.parseInt(s1.nextToken());
    int sum = 0 ;
    while(t-->0){
    	s1= new StringTokenizer(bf.readLine());
    	String s = s1.nextToken();
    	if(s.equals("donate"))
    	 sum += Integer.parseInt(s1.nextToken());
    	else if(s.equals("report"))
    		System.out.println(sum);
    }
    }


}