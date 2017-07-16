package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AddingReversedNumbers713 {

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		while (TC-- > 0) {
			StringBuilder res = new StringBuilder();
			StringBuilder x = new StringBuilder(bf.next());
			StringBuilder y = new StringBuilder(bf.next());
			while (x.length() < y.length())
				x.append(0);
			while (y.length() < x.length())
				y.append(0);
			int car = 0;
			for (int i = 0; i < x.length(); i++) {
				int t = (x.charAt(i) - '0') + (y.charAt(i) - '0') + car;
				// System.out.println(t);
				res.append(t % 10);
				car = t / 10;
			}
			res.append(car);
			int i = res.length() - 1;
			for (; i >= 0 && res.charAt(i) == '0'; i--)
				;
			int j = 0;
			for (; j < res.length() && res.charAt(j) == '0'; j++)
				;
			// System.out.println(res + " " + i + " " + j);
			out.println(res.substring(j, i + 1));
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