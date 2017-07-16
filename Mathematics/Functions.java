package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Functions {
    static int[] fac;

    public static void fac(int n)
    {
	fac = new int[n + 1];
	fac[0] = 1;
	for (int i = 1; i < fac.length; i++)
	{
	    fac[i] = modu(fac[i - 1], i);
	}
    }

    static int[][] comb;

    static void nCr2(int n)
    {
	comb = new int[n + 1][n + 1];
	comb[0][0] = 1;
	for (int i = 1; i < comb.length; i++)
	{
	    comb[i][0] = 1;
	    for (int j = 1; j <= i; j++)
	    {
		comb[i][j] = add(comb[i - 1][j],comb[i - 1][j - 1]);
	    }
	}
    }

    static int[][] f;

    public static void f()
    {
	f = new int[101][1001];
	f[0][0] = 1;
	for (int i = 1; i < 101; i++)
	{
	    for (int j = 1; j < 1001; j++)
	    {
		int sum = 0;
		for (int k = 1; k <= i; k++)
		{
		    sum = add(sum,modu(comb[i][k], f[i - k][j - 1]));
		}
		f[i][j] = sum;
	    }
	}
    }

    static int[][] pow;

    public static void pow()
    {
	pow = new int[1001][101];
	for (int i = 0; i < pow.length; i++)
	{
	    pow[i][0] = 1;
	    for (int j = 1; j < pow[i].length; j++)
	    {
		pow[i][j] = modu(pow[i][j - 1], i);
	    }
	}
    }

    static final int mod = (int) (1e9 + 7);

    public static int modu(long x, long y)
    {
	return (int) ((x * y) % mod);
    }
    public static int add(long x, long y)
    {
	return (int) ((x + y) % mod);
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	nCr2(1001);
	fac(1001);
	pow();
	f();
	for (int i = 1; i <= TC; i++)
	{
	    int x = bf.nextInt();
	    int y = bf.nextInt();
	    int min = Math.min(x, y);
	    int tot = 0;
	    for (int j = 1; j <= y; j++)
	    {
		int sum = 0;
		for (int k = 1; k <= x; k++)
		{
		    sum = add(sum,modu(modu(comb[x][k], comb[y][j]), pow[j][k]));
		}
		tot = add(tot,sum);
	    }
	    int inj = 0;
	    for (int j = 1; j <= y; j++)
	    {
		int sum = 0;
		for (int j2 = 1; j2 <= min; j2++)
		{
		    sum = add(sum,modu(modu(comb[x][j2], comb[j][j2]), fac[j2]));
		}
		inj = add(inj,modu(comb[y][j],sum));
	    }
	    int bij = 0;
	    for (int j = 1; j <= min; j++)
	    {
		bij = add(bij, modu(modu(comb[y][j], comb[x][j]), fac[j]));
	    }
	    int sur = 0;
	    for (int j = 1; j <= x; j++)
	    {
		for (int j2 = 1; j2 <= y; j2++)
		{ 
		    sur = add(sur,modu(modu(comb[x][j],comb[y][j2]),f[j][j2]));
		}
	    }
	    out.printf("Case %d: %d %d %d %d\n", i, inj, sur, bij, tot);
	}
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

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if (x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for (int i = start; i < x.length(); i++)
		if (x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		} else
		{
		    sb.append(x.charAt(i));
		    if (dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg ? -1 : 1);
	}

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if (line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
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
