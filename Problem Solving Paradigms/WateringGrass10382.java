package acm;
import java.io.*;
import java.util.*;
class Ideone {
	static final double EPS = 1e-7;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		while(s!= null){
    	StringTokenizer st  = new StringTokenizer(s);
    	int n = Integer.parseInt(st.nextToken());
    	int l = Integer.parseInt(st.nextToken());
    	int w = Integer.parseInt(st.nextToken());
    	ArrayList<Double> start = new ArrayList<Double>();
    	HashMap<Double,Double> end = new HashMap<Double,Double>();
    	for(int i = 0; i<n;i++){
    		st  = new StringTokenizer(bf.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int r = Integer.parseInt(st.nextToken());
        	double dx = Math.sqrt((double)r*r - (w*w/4.0));
        	if(end.containsKey(x-dx)){
        	 end.put(x-dx, Math.max(end.get(x-dx), x+dx));
        	 }
        	else{
        		start.add(x-dx);
        		end.put(x-dx, x+dx);
        	}
        	
        }
    	Collections.sort(start);
    	/**for(int i = 0 ;i<start.size();i++){
    		System.out.println(start.get(i));
    		System.out.println(end.get(start.get(i)));
    	} 
    	System.out.println();
    	**/
    	double point = 0;
    	int counter = 0;
    	boolean flag = true;
    	for(int i = 0; i<start.size() && flag ;i++){
    		double s1 = start.get(i);
    		if(Math.abs(point- s1)< EPS){
    			counter++;
    			if(point +EPS > l)
    				break;
    			point = end.get(s1);
    		}   
    		else if(point + EPS < s1)
    			flag=  false;
    		else {
    			int j= i+1 ;
    			double maxEnd = end.get(s1);
    			while(j< start.size() && start.get(j) <= point + EPS){
    				maxEnd = Math.max(maxEnd, end.get(start.get(j)));
    				j++;
    			}
    			if(maxEnd > point + EPS){
    				counter ++;
    				//System.out.println(point + " " + s1);
    			}
    			else if(Math.abs(maxEnd - point)< EPS)
    				   break;
    			point = maxEnd; 
    			if(point +EPS > l)
                   break;
    			i=j-1;
    		}
    	}
    	if(flag && point +EPS > l)
    	 System.out.println(counter);
    	else 
    		System.out.println(-1);
    	s= bf.readLine();
    	}
	}

}
