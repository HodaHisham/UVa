package acm;
import java.io.*;
import java.util.*;
public class ThrowingCards10935 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n!= 0){
        	if(n==1){
        		System.out.println("Discarded cards:\nRemaining card: 1");
        	}
        	else{
        	Queue <Integer> q = new LinkedList <Integer>();
        	for(int i = 2; i<=n;i++){
        		q.add(i);
        	}
            System.out.print("Discarded cards: 1");
            while(q.size()>1){
         	   q.add(q.remove());            	
        	   System.out.print(", "+ q.remove());

            }
            System.out.println("\nRemaining card: "+ q.remove());
            }
        st  = new StringTokenizer(bf.readLine());
         n = Integer.parseInt(st.nextToken());
        	
	}
	}

}
