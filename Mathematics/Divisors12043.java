package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Divisors12043 {
	static Pair sumDiv(int N) {
		int idx = 0, p = primes.get(0);
		long sum = 1;
		long num = 1;
		while (p * p <= N) {
			int e = 0;
			while (N % p == 0) {
				N /= p;
				++e;
			}
			sum *= (pow(p, e + 1) - 1) / (p - 1);
			num *= e + 1;
			p = primes.get(++idx);
		}
		if (N != 1) {
			sum *= (pow(N, 2) - 1) / (N - 1);
			num *= 2;
		}
		return new Pair(num, sum);
	}

	static long pow(long a, int n) {
		long res = 1;
		while (n != 0) {
			if ((n & 1) == 1)
				res *= a;
			a *= a;
			n >>= 1;
		}
		return res;
	}

	static ArrayList<Integer> primes;

	public static void main(String[] args) throws IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		primes = new ArrayList<Integer>();
		boolean[] prime = new boolean[100001];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				primes.add(i);
				for (int j = 2 * i; j < prime.length; j += i) {
					prime[j] = false;
				}
			}
		}
		long[] d = new long[100001];
		long[] sig = new long[100001];
		for (int i = 1; i < sig.length; i++) {
			Pair p = sumDiv(i);
			d[i] = p.num;
			sig[i] = p.sum;
		}
		int TC = bf.nextInt();
		while (TC-- > 0) {
			int a = bf.nextInt();
			int b = bf.nextInt();
			int k = bf.nextInt();
			long g = 0, h = 0;
			for (int i = a; i <= b; i++) {
				if (i % k == 0) {
					g += d[i];
					h += sig[i];
				}
			}
			out.println(g + " " + h);
		}
		out.flush();
		out.close();
	}

	static class Pair {
		long num;
		long sum;

		public Pair(long n, long s) {
			num = n;
			sum = s;
		}
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
