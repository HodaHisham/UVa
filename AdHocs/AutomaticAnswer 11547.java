import java.io.*;
import java.util.*;
public class AutomaticAnswer {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int t= Integer.parseInt(s1.nextToken());
    while(t-->0){
    	s1= new StringTokenizer(bf.readLine());
      int n= Integer.parseInt(s1.nextToken());

      System.out.println(Math.abs((315*n+36962)/10)%10);
    }
 }
}