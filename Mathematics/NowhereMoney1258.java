package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NowhereMoney1258 {
	static long[][] comb;			//may need BigInteger, if the numbers are large, use a treemap

	static long nCr1(int n , int k)
	{
		if(n < k)
			return 0;
		if(k == 0 || k == n)
			return 1;
		if(comb[n][k] != -1)
			return comb[n][k];
		if(n - k < k)
			return comb[n][k] = nCr1(n, n - k);
		return comb[n][k] = nCr1(n - 1, k - 1) + nCr1(n - 1, k);
	}
	public static void main(String[] args) throws Exception
	{
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		comb = new long[100][100];
		for(long[]i:comb)
			Arrays.fill(i, -1);
		BigInteger [] tab = new BigInteger[100];
		for (int k = 0; k < 100; k++)
		{
			int n = k/2, i = k%2 == 0?0:1;
			BigInteger ans = BigInteger.ZERO;
			for (int j = 0; j <= n; j++,i+=2)
			{
				ans = ans.add(BigInteger.valueOf(nCr1(n-j+i-1, n-j)));
			}
			tab[k] = ans;
		}
		while(bf.ready())
		{
			BigInteger f = new BigInteger(bf.next());
			sb.append(f).append("\n");
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<BigInteger> b = new ArrayList<BigInteger>();
			while(f.compareTo(BigInteger.ZERO) > 0)
			{
				int idx = Arrays.binarySearch(tab, f);
				if(idx < 0) idx = -(idx+1)-1;
				if(f.equals(BigInteger.ONE))
					idx = 2;
				a.add(idx-1);
				b.add(tab[idx]);
				f = f.subtract(tab[idx]);
				//			    System.out.println(tmp + " "+idx);
			}
			for (int i = 0; i < a.size(); i++)
			{
				sb.append(a.get(i)).append(" ");
			}
			//	    sb.append(a.get(a.size()-1)).append("\n");
			sb.append("\n");
			for (int i = 0; i < b.size(); i++)
			{
				sb.append(b.get(i)).append(" ");
			}
			//	    sb.append(b.get(b.size()-1)).append("\n\n");
			sb.append("\n\n");

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