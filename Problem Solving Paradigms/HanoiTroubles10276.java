package acm;
import java.io.*;
import java.util.*;
class HanoiTroubles10276 {
    static int[] a;
    public static boolean canPlace(int i ,int x){
    	if(i== a.length)
    		return false;
    	else if(a[i] == 0 ){
    		a[i] = x;
    		return true;
    	}
    	else if((int)(Math.sqrt(a[i] + x))== Math.sqrt(a[i] + x)){
    		    a[i] = x;
    		    return true;
    	}
    	else return canPlace(i+1, x);
    }
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st  = new StringTokenizer(bf.readLine());
    	int t = Integer.parseInt(st.nextToken());
    	while(t-->0){
    		st  = new StringTokenizer(bf.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	a= new int[n];
        	int i = 1;
        	while(canPlace(0,i)){
        		i++;
        	}
        	System.out.println(i-1);
        		
    	}

	}

}
