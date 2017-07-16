package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JumpingChampion914 {
	static ArrayList<Integer> primes;
	static int[] isComposite;

	static void sieve(int N) // O(N log log N)
	{

		isComposite = new int[N + 1];
		isComposite[0] = isComposite[1] = 1; // 0 indicates a prime number
		primes = new ArrayList<Integer>();

		for (int i = 2; i <= N; ++i) // can loop till i*i <= N if primes array
										// is not needed O(N log log sqrt(N))
			if (isComposite[i] == 0) // can loop in 2 and odd integers for
										// slightly better performance
			{
				primes.add(i);
				if (1l * i * i <= N)
					for (int j = i * i; j <= N; j += i) // j = i * 2 will not
														// affect performance
														// too much, may alter
														// in modified sieve
						isComposite[j] = 1;
			}
	}

	public static int bs(int lo, int hi, int num) {

		int ans = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (primes.get(mid) >= num) {
				ans = mid;
				hi = mid - 1;
			} else
				lo = mid + 1;
		}
		return ans;
	}

	public static int bs2(int lo, int hi, int num) {

		int ans = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (primes.get(mid) <= num) {
				ans = mid;
				lo = mid + 1;
			}

			else
				hi = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = bf.nextInt();
		sieve(1000000);
		while (TC-- > 0) {
			int l = bf.nextInt();
			int u = bf.nextInt();
			int min = bs(0, primes.size() - 1, l);
			int max = bs2(0, primes.size() - 1, u);
			// System.out.println(min + " " + max);
			if (min == max)
				out.println("No jumping champion");
			else {
				int diff[] = new int[100000];
				for (int i = min; i < max; i++) {
					diff[primes.get(i + 1) - primes.get(i)]++;
				}
				int ans = 0;
				int occ = 0;
				for (int i = 1; i < diff.length; i++) {
					if (diff[i] > diff[ans]) {
						ans = i;
						occ = 1;
					} else if (diff[i] == diff[ans]) {
						occ++;
					}
				}
				out.println(occ > 1 ? "No jumping champion" : "The jumping champion is " + ans);
			}
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
