package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class GuessDataStructure11995 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String str = bf.readLine();
		while(str!= null && !str.isEmpty()){
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			boolean stack = true;
			boolean queue = true;
			boolean priority = true;
			Stack<Integer> s = new Stack<Integer>();
			Queue<Integer> q = new LinkedList<Integer>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(100, new Sorter ());
			while(n-->0 ){
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(x==1)
				{
					s.push(y);
					q.add(y);
					pq.add(y);
				}
				else if(x==2)
				{
					if(s.isEmpty())stack =false;  if(q.isEmpty()) queue = false;  if(pq.isEmpty())priority = false;
				 else{
					int a = s.pop();
					int b = q.remove();
					int c = pq.remove();
					if(a != y) stack =false;
					if(b != y) queue = false;
					if(c != y) priority = false;
				}//	out.println(a+ " "+ b+ " "+c +" "+y+" "+stack + " "+ queue+ " "+ priority);
				}
			}
			int sum = (stack? 1:0 )+ (queue?1:0 )+ (priority? 1:0);
			if(sum >1)
				out.println("not sure");
			else if(sum == 0)
				out.println("impossible");
			else
				out.println(stack? "stack": queue? "queue": "priority queue");
			str= bf.readLine();
		}
		out.flush();
		out.close();
	}

}
class Sorter implements Comparator<Integer>
   { public int compare(Integer x1,Integer x2){
	        return x2-x1;
     }
   }
