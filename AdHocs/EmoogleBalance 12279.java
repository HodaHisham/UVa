import java.io.*;
import java.util.*;
public class EmoogleBalance {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int n= Integer.parseInt(s1.nextToken());
    int i =1;
    int t =0 ;
    while(n != 0){
    	t=0;
        s1= new StringTokenizer(bf.readLine());
        for(int j = 1; j<=n;j++){
        	int k= Integer.parseInt(s1.nextToken());
        	if(k ==0) t--;
        	else 	t++;
        }

        System.out.println("Case " + (i++) + ": "+ t);
    	s1= new StringTokenizer(bf.readLine());
     n= Integer.parseInt(s1.nextToken());
    }
 }
}