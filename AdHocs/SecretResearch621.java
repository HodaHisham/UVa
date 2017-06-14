import java.io.*;
import java.util.*;
public class SecretResearch {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int n= Integer.parseInt(s1.nextToken());
    while(n-->0){
    	String s = bf.readLine();
    	char c;
    	if(s.equals("1")||s.equals("4")||s.equals("78"))
    		c = '+';
    	else if(s.endsWith("35"))
    		 c='-';
    		else if(s.endsWith("4")&& s.startsWith("9"))
    			c='*';
    			else if(s.startsWith("190"))
    				c= '?';
    				else continue;
        System.out.println(c);
    }
    }


}