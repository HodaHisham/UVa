import java.io.*;
import java.util.*;
public class PackingforHoliday12372 {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int t= Integer.parseInt(s1.nextToken());
    for(int i =1; i<=t;i++){
    	String s = "good";
    	s1= new StringTokenizer(bf.readLine());
    	for(int j = 1;j<=3;j++){
    		if(Integer.parseInt(s1.nextToken())> 20){
    		 			s = "bad";
    		 			break;
    		}
    	}
    	System.out.println("Case " + i + ": " + s);
    }
    }


}