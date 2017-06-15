import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AddAll10954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String s;

		StringTokenizer st;
		while (true) {
			int n = Integer.parseInt(new StringTokenizer(br.readLine())
					.nextToken());
			if (n == 0)
				break;
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				pq.add(Integer.parseInt(st.nextToken()));
			//while(!pq.isEmpty())
				//System.out.println(pq.poll());
			int cost = 0;
			while (pq.size() > 1) {
				int x = pq.poll() + pq.poll();
				pq.add(x);
				cost += x;
			}
			System.out.println(cost);
		}
	}

}
