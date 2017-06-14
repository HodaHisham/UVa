import java.io.*;
import java.util.*;
public class subPrime {
   public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    int b= Integer.parseInt(st.nextToken());
    int n= Integer.parseInt(st.nextToken());
    while(b != 0 && n!= 0){
    	int [] res = new int[b+1];
        st= new StringTokenizer(bf.readLine());
        for(int j = 1;j<b+1;j++)
           res[j]= Integer.parseInt(st.nextToken());
        while(n-->0){
        	st= new StringTokenizer(bf.readLine());
        	int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            res[c] += v;
            res[d] -= v;
        }
    boolean flag = true;
    for(int i =1; i<res.length;i++){
    	if(res[i] <0 && flag){
    			System.out.println("N");
    			flag = false;
    	}
    }
    if(flag)
    	System.out.println("S");
    st= new StringTokenizer(bf.readLine());
    b= Integer.parseInt(st.nextToken());
    n= Integer.parseInt(st.nextToken());
    }
}
}