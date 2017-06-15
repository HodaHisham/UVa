package acm;
import java.io.*;
import java.util.*;
public class Ants {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
    	int k = Integer.parseInt(st.nextToken());
    	while(k-->0){
    		st  = new StringTokenizer(bf.readLine());
    		int l = Integer.parseInt(st.nextToken());
    	    int n = Integer.parseInt(st.nextToken());
    	    int minAfMid = 1000001;
    	    int maxBMid= -1;
    	    int min = 1000001;
    	    int max = 0; 		
    	    st  = new StringTokenizer(bf.readLine());
    	    int[] a = new int[n];
    	    for (int i = 0; i < n; i++) {
				a[i] =Integer.parseInt(st.nextToken());
				if(a[i] >= (l/2) && a[i]< minAfMid)
					minAfMid = a[i];
				
				if(a[i] <= (l/2) && a[i]> maxBMid)
					maxBMid= a[i];
				max = Math.max(max, a[i]);
				min = Math.min(a[i], min);
    	    }
    	    //System.out.println(minInd + " " + maxInd);
         System.out.println(Math.max(maxBMid,l-minAfMid) + " " + Math.max(max, l-min));
    	}
	}

}
