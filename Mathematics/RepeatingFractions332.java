package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RepeatingFractions332 {

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static int[] powTn = { 1, (int) 1e1, (int) 1e2, (int) 1e3, (int) 1e4, (int) 1e5, (int) 1e6, (int) 1e7, (int) 1e8,
			(int) 1e9 };

	public static void main(String[] args) throws IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = 1;
		while (true) {
			int j = bf.nextInt();
			if (j == -1)
				break;
			String num = bf.next();
			int k = num.length() - 2 - j;
			String s1 = num.substring(2), s2 = num.substring(2, 2 + k);
			int n = 0, d = 0;
			if (j > 0) {
				n = Integer.parseInt(s1.isEmpty() ? "0" : s1) - Integer.parseInt(s2.isEmpty() ? "0" : s2);
				d = powTn[k + j] - powTn[k];
			} else {
				n = Integer.parseInt(s1);
				d = powTn[k];
			}
			int g = gcd(n, d);
			n /= g;
			d /= g;
			out.printf("Case %d: %d/%d\n", TC++, n, d);

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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
