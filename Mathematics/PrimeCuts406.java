package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimeCuts406 {
	static int[] prime;

	static void sieve() {
		prime = new int[1001];
		Arrays.fill(prime, 1);
		prime[0] = 0;
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == 1) {
				for (int j = i * i; j < prime.length; j += i)
					prime[j] = 0;
			}
		}
		for (int i = 1; i < prime.length; i++) {
			prime[i] += prime[i - 1];
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		sieve();
		StringBuilder sb = new StringBuilder();
		while (bf.ready()) {
			int n = bf.nextInt(), c = bf.nextInt(), num = 0, f = 0, s = 0;
			sb.append(n).append(" ").append(c).append(":");
			if ((prime[n] & 1) == 0)
				num = 2 * c;
			else
				num = 2 * c - 1;
			if (prime[n] < num) {
				f = 1;
				s = prime[n];
			} else {
				f = prime[n] / 2 - c + ((prime[n] & 1) == 0 ? 1 : 2);
				s = f + num - 1;
			}
			for (int i = 1; i <= n && f <= s; i++) {
				if (prime[i] != prime[i - 1] && prime[i] == f) {
					sb.append(" ").append(i);
					f++;
				}
			}
			sb.append("\n\n");
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