package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class FactorialFrequencies324 {
	static BigInteger[] fac;
	static int[][] dig;

	public static void fac(int n) {
		fac = new BigInteger[n + 1];
		fac[0] = BigInteger.ONE;
		dig = new int[n + 1][10];
		for (int i = 1; i < fac.length; i++) {
			fac[i] = fac[i - 1].multiply(BigInteger.valueOf(i));
			dig(i, fac[i].toString());
		}
	}

	public static void dig(int ind, String b) {
		for (int i = 0; i < b.length(); i++) {
			dig[ind][b.charAt(i) - '0']++;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		fac(366);
		while (true) {
			int n = bf.nextInt();
			if (n == 0)
				break;
			out.println(n + "! --");
			for (int i = 0; i < 5; i++) {
				out.printf("     (%d)     %3d", i, dig[n][i]);
			}
			out.println();
			for (int i = 5; i < 10; i++) {
				out.printf("     (%d)     %3d", i, dig[n][i]);
			}
			out.println();
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

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
