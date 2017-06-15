package acm;
import java.io.*;
import java.util.*;
 public class FractionsAgain10976 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
    	while(s!= null){
    		StringTokenizer st  = new StringTokenizer(s);
        	int k = Integer.parseInt(st.nextToken());
        	ArrayList <Integer> a = new ArrayList <Integer>();
        	ArrayList <Integer> b = new ArrayList <Integer>();
        	a.add(k*2);
        	b.add(k*2);
        	int y = k*2-1;
        	if(k==1){
        	System.out.println(a.size());
        	System.out.println("1/"+k+ " = 1/"+ a.get(0)+" + 1/"+ b.get(0));
        	}
        	else{
        	double x= (double)y*k /(y-k);
        	while(y> 1 && x>1){
        		x= (double)y*k /(y-k);
        		//System.out.println(x + " "+ y);
        		if(x>1 && (int)x==x)
        		{
        			a.add((int)x);
        			b.add( y);
        		}
        		y--;
        	} 
        	System.out.println(a.size());
        	for(int i = a.size()-1; i>=0; i--)
        		System.out.println("1/"+k+ " = 1/"+ a.get(i)+" + 1/"+ b.get(i));
        	}
        	s= bf.readLine();
    	}
	}

}





