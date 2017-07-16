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

public class AlternateTask11728 {

	static ArrayList<Integer> primes;
	static Pair inv = new Pair(-1, -1);

	static Pair sumDiv(int N) {
		int idx = 0, p = primes.get(0);
		int sum = 1;
		int tmp = N;
		while (p * p <= N) {
			int e = 0;
			while (N % p == 0) {
				N /= p;
				++e;
			}
			sum *= (pow(p, e + 1) - 1) / (p - 1);
			if (sum > 1000)
				return inv;
			p = primes.get(++idx);
		}
		if (N != 1) {
			sum *= (pow(N, 2) - 1) / (N - 1);
			if (sum > 1000)
				return inv;
		}
		return new Pair(tmp, sum);
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

	public static void main(String[] args) throws Exception {
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
		int[] val = new int[1001];
		Arrays.fill(val, -1);
		for (int i = 1; i <= 1000; i++) {
			Pair tmp = sumDiv(i);
			if (!tmp.equals(inv)) {
				val[tmp.sum] = i;
			}
		}
		int cases = 1;
		while (true) {
			int s = bf.nextInt();
			if (s == 0)
				break;
			out.println("Case " + cases++ + ": " + val[s]);
		}
		out.flush();
		out.close();
	}

	static class Pair {
		int num;
		int sum;

		public Pair(int n, int s) {
			num = n;
			sum = s;
		}

		public String toString() {
			return num + " " + sum;
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

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
