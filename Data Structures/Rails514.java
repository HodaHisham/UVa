package acm;
import java.io.*;
import java.util.*;
public class rails {

	public static void main(String[] args) throws java.lang.Exception{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st  = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n!= 0){
        	int [] a =new int[n];
        	st  = new StringTokenizer(bf.readLine());
        	Stack <Integer> tmp = new Stack<Integer>();
        	for(int i = 1; i<=n;i++)
        		tmp.push(i);
        	a[0] = Integer.parseInt(st.nextToken());
        	while(!(a[0] != 0 && !st.hasMoreTokens() )){
        		
        		for(int i = 1;i<n;i++){
        			a[i]= Integer.parseInt(st.nextToken());
        		}
        		
        	}
        	st  = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
        }
	}

}
