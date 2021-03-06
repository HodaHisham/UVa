package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bee11000 {
	static long fib[];

	static long fibonacci(int n) // O(log n)
	{
		if (n == 0)
			return 0L;
		if (n <= 2)
			return 1L;
		if (fib[n] != -1)
			return fib[n];

		int k = n >> 1;
		long a = fibonacci(k), b = fibonacci(k + 1);

		if (n % 2 == 0)
			return fib[n] = a * (2 * b - a);
		return fib[n] = b * b + a * a;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		fib = new long[10000];
		Arrays.fill(fib, -1L);
		while (true) {
			int n = bf.nextInt();
			if (n == -1)
				break;
			out.println((fibonacci(n + 2) - 1) + " " + (fibonacci(n + 3) - 1));
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

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
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
