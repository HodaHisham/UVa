package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PeterSmokes10346 {

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (bf.ready()) {
			int n = bf.nextInt(), k = bf.nextInt();
			int ans = n + n / k;
			n = n % k + n / k;
			while (n >= k) {
				ans += n / k;
				n = n % k + n / k;
			}
			out.println(ans);
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
