package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HowManyFibs10183 {
	static BigInteger fib[];

	static BigInteger fibonacci(int n) // O(log n)
	{
		if (n == 0)
			return fib[n] = BigInteger.ZERO;
		if (n <= 2)
			return fib[n] = BigInteger.ONE;
		if (fib[n] != null)
			return fib[n];

		int k = n >> 1;
		BigInteger a = fibonacci(k), b = fibonacci(k + 1);

		if (n % 2 == 0)
			return fib[n] = a.multiply(b.multiply(BigInteger.valueOf(2)).subtract(a));
		return fib[n] = b.multiply(b).add(a.multiply(a));
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		fib = new BigInteger[500];
		StringBuilder sb = new StringBuilder("1");
		for (int j = 0; j < 100; j++) {
			sb.append('0');
		}
		BigInteger c = new BigInteger(sb.toString());
		int i = -1;
		while (i == -1 || fib[i].compareTo(c) < 0 || i < 500 - 1)
			fib[++i] = fibonacci(i);
		sb = new StringBuilder();
		while (true) {
			BigInteger a = new BigInteger(bf.next());
			BigInteger b = new BigInteger(bf.next());
			if (a.compareTo(BigInteger.ZERO) == 0 && b.compareTo(BigInteger.ZERO) == 0)
				break;
			int idx = Arrays.binarySearch(fib, a);
			if (idx < 0)
				idx = -(idx + 1);
			int idx2 = Arrays.binarySearch(fib, b);
			if (idx2 < 0)
				idx2 = -(idx2 + 1) - 1;
			idx = Math.max(idx, 2);
			idx2 = Math.max(idx2, 2);
			sb.append(idx2 - idx + 1).append("\n");
		}
		out.print(sb);
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