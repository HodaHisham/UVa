import java.io.*;
import java.util.*;
public class EcologicalPremium {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int n= Integer.parseInt(s1.nextToken());
    while(n-->0){
    	int sum = 0;
    	s1= new StringTokenizer(bf.readLine());
        int f= Integer.parseInt(s1.nextToken());
    while(f-->0){
    	s1= new StringTokenizer(bf.readLine());
    	int a= Integer.parseInt(s1.nextToken());
    	s1.nextToken();
    	int b= Integer.parseInt(s1.nextToken());
    	sum += (a*b);
    }
    System.out.println(sum);
    }
 }


}