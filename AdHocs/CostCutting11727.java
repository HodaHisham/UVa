import java.io.*;
import java.util.*;
public class CostCutting {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int t= Integer.parseInt(s1.nextToken());
    for(int i = 1; i<= t; i++){
    	s1= new StringTokenizer(bf.readLine());
    int a= Integer.parseInt(s1.nextToken());
    int b= Integer.parseInt(s1.nextToken());
    int c= Integer.parseInt(s1.nextToken());
    int [] ans = new int[3];
    ans[0]= a;
    ans[1] = b;
    ans[2] = c;
    Arrays.sort(ans);
    System.out.println("Case " + i + ": "+ ans[1] );
    }
 }
}
