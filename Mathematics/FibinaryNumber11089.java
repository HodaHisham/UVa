package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FibinaryNumber11089 {
	static int fib[];

	static int fibonacci(int n) // O(log n)
	{
		if (n == 0)
			return fib[n] = 0;
		if (n <= 2)
			return fib[n] = 1;
		if (fib[n] != -1)
			return fib[n];

		int k = n >> 1;
		int a = fibonacci(k), b = fibonacci(k + 1);

		if (n % 2 == 0)
			return fib[n] = a * (2 * b - a);
		return fib[n] = b * b + a * a;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		fib = new int[50];
		Arrays.fill(fib, -1);
		for (int i = 0; i < 46; i++) {
			if (fib[i] == -1)
				fibonacci(i);
		}
		int T = bf.nextInt();
		while (T-- > 0) {
			int n = bf.nextInt();
			int tmp = n;
			String num = "";
			for (int i = 45; i > 1; i--) {
				if (fib[i] <= tmp) {
					num += 1;
					tmp -= fib[i];
				} else if (!num.equals(""))
					num += 0;
			}
			out.println(num);
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
