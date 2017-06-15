package acm;
import java.io.*;
import java.util.*;
public class ThroughDesert11935 {
	static double EPS = 1e-12;
	static ArrayList<Integer> dist;
	static ArrayList<Integer> consum;
	static ArrayList<Integer> events;
    public static boolean can(int n,double mid){
    	//double x = 0;
    	int leak= 0;
    	double tmp= mid;
    	//boolean flag = true;
    	int distance = 0;
    	for(int i = 0; i<dist.size() ;i++){
    		int e = events.get(i);
    		int d = dist.get(i);
    		//System.out.print(mid);
    		mid -= ((double)(d-distance)/100 * consum.get(n));
    		mid -= ((d-distance)*leak);
    	   // System.out.println(" " +leak+" "+ d+" "+ mid+" "+e);
    		
    		if(mid + EPS < 0){
    			break;
    		} 
    		switch(e){
    		case 0:{
    		    n ++;
    		    break;
    		}
    		case 1: {
    			if(mid + EPS < 0){
        			break;
        		}
    			mid = tmp;
    			break;
    		}
    		case 2:{
    			leak ++;
    			break;
    		}
    		case 3:{
    			leak = 0;
    			break;
    		}
    		default:
    			break;
    		
    		}
    		distance = d; 
    		
    	}
		return mid +EPS > 0;
    }
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	String s = bf.readLine();
    	HashMap <String,Integer> h= new HashMap<String, Integer>();
    	h.put("Fuel",0);
    	h.put("Gas",1);
    	h.put("Leak",2);
    	h.put("Mechanic",3);
    	h.put("Goal",4);
    	while(!s.equals("0 Fuel consumption 0")){
        	dist = new ArrayList <Integer>();
        	events = new ArrayList <Integer>();
        	consum = new ArrayList <Integer>();
        	StringTokenizer st  = new StringTokenizer(s);
        	int d = Integer.parseInt(st.nextToken());
        	//dist.add(d);
        	s= st.nextToken();
        	if(s.equals("Fuel"))
        		st.nextToken();
        	consum.add(Integer.parseInt(st.nextToken()));
        	while(!s.equals("Goal")){  // getting input
        		st  = new StringTokenizer(bf.readLine());
                d = Integer.parseInt(st.nextToken());
                dist.add(d);
            	s= st.nextToken();
            	if(s.equals("Fuel")){
            		st.nextToken();
            		events.add(0);
             	   consum.add(Integer.parseInt(st.nextToken()));
            	}
            	else {if (s.equals("Gas"))
            		   st.nextToken();
            	
            	  events.add(h.get(s));	
            	}

        	}
        	/**while(!dist.isEmpty())
        		System.out.println(dist.remove());
        	System.out.println();
        	while(!events.isEmpty())
        		System.out.println(events.remove());**/
        	double lo = 0, hi =10000, mid= 5000, ans=10000;
        	while (Math.abs(hi-lo)>EPS ){
        		mid = (lo+hi)/2.0;
        		//System.out.println(mid);
        		if(can(0,mid)){
        			ans = mid; 
        			hi = mid; 
        			//System.out.println(ans);
        		}
        		else
        			lo = mid;
        		
        	} 
        	
        	System.out.printf("%.3f\n", ans);
        	s = bf.readLine();
    	}

	}

}
