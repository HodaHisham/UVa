/**
 * @(#)CombinationLock.java
 *
 *
 * @author
 * @version 1.00 2015/12/19
 */

import java.io.*;
import java.util.*;
public class CombinationLock10550 {
  public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    String str;
    String [] s;
    int []a = new int [4];
    int degrees= 0;
    while(!((str = bf.readLine()).equals("0 0 0 0"))){
       degrees = 0;
       s = str.split(" ");
       for(int i = 0 ;i<4;i++ )
       	a[i] = Integer.parseInt(s[i]);
       	if(a[1]>a[0])
          degrees += (40-a[1]+a[0]);
       else
          degrees += (a[0]-a[1]);
       if(a[1]>a[2])
          degrees += (40-a[1]+a[2]);
       else
          degrees += (a[2]-a[1]);
       if(a[3]>a[2])
          degrees += (40-a[3]+a[2]);
       else
          degrees += (a[2]-a[3]);
       System.out.println(9*degrees +1080);
    }
  }

}