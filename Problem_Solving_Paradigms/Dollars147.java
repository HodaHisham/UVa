package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dollars147 {
    static int [] coins = {5,10,20,50,100,200,500,1000,2000,5000,10000};

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	long [][] dp = new long[30001][2];
	Arrays.fill(dp[0], 1);
	int p = 0;
	for (int j = 0; j < 11; j++)
	{
	    p ^= 1;
	    for (int i = 5; i < dp.length; i+=5)
	    {
		dp[i][p] = 0;
		if(j > 0)
		    dp[i][p] = dp[i][1^p];
		if(i - coins[j] >= 0)
		    dp[i][p] += dp[i-coins[j]][p];
	    }
	}
	while(true){
	    String tmp = bf.next();
	    int n = Integer.parseInt(tmp.substring(0,tmp.length()-3)+tmp.substring(tmp.length()-2, tmp.length()));
	    if(n == 0) break;

	    out.printf("%6s%17d\n",tmp,dp[n][p]);
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
	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if(x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for(int i = start; i < x.length(); i++)
		if(x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		}
		else
		{
		    sb.append(x.charAt(i));
		    if(dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg?-1:1);
	}
    }
}
