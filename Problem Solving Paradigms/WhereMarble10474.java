package acm;
import java.io.*;
import java.util.*;
public class whereMarble {
	public static int binaryS(int [] a, int d){
		int ind = -1;
		int low= 0, high = a.length-1, mid = low+high/2;
		while(low <= high){
			mid = (low + high)/2;
			if(a[mid] == d){
				ind = mid;
				high = mid-1;
			}
			else if(a[mid]> d)
				 high = mid-1;
			else 
				low = mid+1;
		}
		return ind;
	}
    public static void main(String [] args) throws java.lang.Exception{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st  = new StringTokenizer(bf.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int q = Integer.parseInt(st.nextToken());
    	int count =0;
    	while(n!= 0 && q!= 0){
    		int[] a= new int[n];
    		for(int i = 0; i<n;i++){
    			st  = new StringTokenizer(bf.readLine());
    			a[i] = Integer.parseInt(st.nextToken());
    		}
    		Arrays.sort(a);
    		System.out.println("CASE# " + ++count + ":");
    		for(int i = 0; i<q;i++){
    			st  = new StringTokenizer(bf.readLine());
    			int d= Integer.parseInt(st.nextToken());
    			int ind = binaryS(a, d);
    			if(ind!=-1)
    				System.out.println(d + " found at " + (ind+1));
    			else 
    				System.out.println(d + " not found");
    		}
    		st  = new StringTokenizer(bf.readLine());
        	 n = Integer.parseInt(st.nextToken());
        	 q = Integer.parseInt(st.nextToken());
    	}
    }
}