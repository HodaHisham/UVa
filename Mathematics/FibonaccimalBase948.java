package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FibonaccimalBase948 {

	static int fib[];

	static int fibonacci(int n) // O(log n)
	{
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;
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
		fib = new int[45];
		Arrays.fill(fib, -1);
		for (int i = 0; i < fib.length; i++) {
			fib[i] = fibonacci(i);
		}
		StringBuilder ans = new StringBuilder();
		int TC = bf.nextInt();
		while (TC-- > 0) {
			int n = bf.nextInt();
			int N = n;
			int tmp = -1;
			StringBuilder sb = new StringBuilder();
			if (n == 0)
				sb.append('0');
			while (n > 0) {
				int idx = Arrays.binarySearch(fib, n);
				if (idx < 0)
					idx = -(idx + 1) - 1;
				if (n == 1)
					idx = 2;
				n -= fib[idx];
				if (tmp == -1)
					tmp = idx;
				while (tmp-- > idx) {
					sb.append('0');
				}
				sb.append('1');
			}
			while (tmp-- > 1) {
				sb.append('0');
			}
			ans.append(String.format("%d = %s (fib)\n", N, sb.toString()));
		}
		out.print(ans);
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