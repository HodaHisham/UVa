import java.io.*;
import java.lang.*;
public class p8 {
     public static void main(String[] args) throws java.lang.Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= x; i++){
            String s = bf.readLine();
            String[] st = s.split(" ");
            int [] a = new int[2];
            for(int j = 0; j<a.length; j++){
                a[j] = Integer.parseInt(st[j]);
            }
         if(a[0] > a[1]) System.out.println(">");
         else if (a[1]>a[0]) System.out.println("<");
              else System.out.println("=");


        }


    }
}