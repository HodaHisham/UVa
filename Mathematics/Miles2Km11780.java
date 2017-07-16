package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Miles2Km11780 {
	static int fib[];

	static int fibonacci(int n) 		//O(log n)
	{
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;
		if (fib[n] != -1)
			return fib[n];

		int k = n >> 1;
		int a = fibonacci(k), b = fibonacci(k+1);

		if (n%2 == 0)
			return fib[n] = a * (2 * b - a);
		return  fib[n] = b * b + a * a;
	}
	static int [][] memo;
	static double tmp;
	static int INF = (int)1e6;
	static int dp(int i, int n)
	{
		if(n < 0)
			return INF;
		if(n == 0)
			return 0;
		if(i == fib.length-1) 
			return INF;
		if(memo[i][n] != -1)
			return memo[i][n];
		int ans = dp(i,n-fib[i]) + fib[i+1];
		int ans2 = dp(i+1,n);
		if(Math.abs(tmp-ans2) < Math.abs(tmp-ans))
			ans = ans2;
		return memo[i][n] = ans;
	}
	public static void main(String[] args) throws Exception
	{
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		fib = new int[20];
		memo = new int[21][1001];
		for(int [] i:memo)
			Arrays.fill(i, -1);
		Arrays.fill(fib, -1);
		for(int i = 0; i < fib.length; i++)
			fib[i] = fibonacci(i);
		while(true)
		{
			int n = bf.nextInt();
			if(n == 0)
				break;
			tmp = 1.6*n;
			sb.append(String.format("%.2f\n", Math.abs(tmp-dp(2,n))));
		}
		out.print(sb);
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s)
		{
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader)
		{
			br = new BufferedReader(fileReader);
		}

		public String next() throws IOException
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException
		{
			return br.readLine();
		}

		public boolean ready() throws IOException
		{
			return br.ready();
		}
	}
}