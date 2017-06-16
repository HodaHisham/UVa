package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Counting10198 {

    static BigInteger [] memo;
    static int n;
    public static BigInteger dp(int sum){
	if(sum == n)
	    return BigInteger.ONE;
	if(sum > n)
	    return BigInteger.ZERO;
	if(memo[sum]!=null)
	    return memo[sum];
	BigInteger ans = BigInteger.ZERO;
	for (int i = 1; i <= 4; i++)
	{
	    ans = ans.add(dp(sum+(i==4?1:i)));
	}
	return memo[sum] = ans;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    n = bf.nextInt();
	    memo = new BigInteger[1001];
	    out.println(dp(0));
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
    }
}
