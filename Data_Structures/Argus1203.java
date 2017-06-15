package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Argus1203 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		PriorityQueue <Pair >pq = new PriorityQueue<Pair>();
		while(!st.nextToken().equals("#")){

			int q_num = Integer.parseInt(st.nextToken());
			int period = Integer.parseInt(st.nextToken());
			pq.add(new Pair(q_num , period, period));
			st = new StringTokenizer(bf.readLine());
		}
		st = new StringTokenizer(bf.readLine());
		int k = Integer.parseInt(st.nextToken());
		while(k-->0){
			Pair p = pq.remove();
			out.println(p.q_num);
			pq.add(new Pair(p.q_num, p.period , p.time + p.period));
		}
		out.flush();
		out.close();
	}
	static class Pair implements Comparable{
		int q_num;
		int period;
		int time;
		public Pair(int q, int p,int t){
			q_num = q;
			period = p;
			time = t;
		}
		public int compareTo(Object o){
			Pair p = (Pair)o;
			if(time != p.time)
			return time-p.time ;
			else
				return q_num - p.q_num; 
		}
	}
}
