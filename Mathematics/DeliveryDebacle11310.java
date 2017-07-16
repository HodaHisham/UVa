package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DeliveryDebacle11310 {
	static long dp(int idx, int prev) // prev == 0 -> no empty cell in previous
										// col, prev == 1 empty
	{
		if (idx < -1)
			return 0;
		if (idx == -1)
			return 1;
		if (memo[idx][prev] != -1)
			return memo[idx][prev];
		long ans = 0;
		if (prev == 1)
			ans += dp(idx - 1, 0) + dp(idx, 0);
		else {
			ans += 2 * (dp(idx - 2, 0) + dp(idx - 2, 1)) + dp(idx - 1, 0);
		}
		return memo[idx][prev] = ans;
	}

	static long[][] memo;

	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		memo = new long[50][3];
		for (long[] i : memo)
			Arrays.fill(i, -1);
		int TC = bf.nextInt();
		while (TC-- > 0) {
			sb.append(dp(bf.nextInt() - 1, 0)).append("\n");
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