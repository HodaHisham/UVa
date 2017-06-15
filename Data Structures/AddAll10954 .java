package acm;
import java.io.*;
import java.util.*;
public class addAll {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n!= 0){
        	st  = new StringTokenizer(bf.readLine());
        	PriorityQueue <Integer> pq =new PriorityQueue<Integer>();
        	
        	long previous = 0; 
        	for(int i = 0; i<n;i++)
        		pq.add(Integer.parseInt(st.nextToken()));
        	previous += pq.remove();
        	if(!pq.isEmpty())
        		previous += pq.remove();
        	long total = previous;
        	while(!pq.isEmpty()){
        		previous +=  pq.remove();
        		total += previous;
        	}
        	System.out.println(total);
        	st  = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
        }

	}

}
