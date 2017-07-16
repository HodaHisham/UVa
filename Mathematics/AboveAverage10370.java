package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AboveAverage10370 {

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = bf.nextInt();
		while (c-- > 0) {
			int n = bf.nextInt();
			int[] a = new int[n];
			int sum = 0, num = 0;
			for (int i = 0; i < a.length; i++) {
				a[i] = bf.nextInt();
				sum += a[i];
			}
			double avg = 1.0 * sum / n;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > avg)
					num++;
			}
			out.printf("%.3f", num * 100.0 / n);
			out.println("%");
		}
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader) {
			br = new BufferedReader(fileReader);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}