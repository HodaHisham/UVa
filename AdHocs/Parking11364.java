/**
 * @(#)Parking.java
 *
 *
 * @author
 * @version 1.00 2015/12/19
 */

import java.io.*;
import java.util.*;
public class Parking {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer s1= new StringTokenizer(bf.readLine());
    int t= Integer.parseInt(s1.nextToken());
    while(t-->0){
    	 int n= Integer.parseInt(bf.readLine().split(" ")[0]);
         String []str = bf.readLine().split(" ");
         int min = 100, max = 0;
         for(int i = 0; i<n;i++){
             int j = Integer.parseInt(str[i]);
             max = Math.max(max, j);
             min = Math.min(min, j);

         }
         System.out.println(2*(max-min));
    }

    }


}