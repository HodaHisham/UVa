
package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumDiffPrimes1213 {

    static int [][][] memo;
    static int n,k;

    public static int dp(int sum, int ind, int rem){
	if(rem == 0)
	    return sum==n?1:0;
	if(ind == primes.size() || sum >= n)
	    return 0;
	if(memo[sum][ind][rem] != -1)
	    return memo[sum][ind][rem];
	int take = 0;
	if(primes.get(ind) + sum <= n)
	    take = dp(sum+primes.get(ind),ind+1,rem-1);
	return memo[sum][ind][rem] = take + dp(sum,ind+1,rem);
    }
    static ArrayList<Integer> primes;
    static int[] isComposite;

    static void sieve(int N)	// O(N log log N) 
    {
	isComposite = new int[N+1];					
	isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
	primes = new ArrayList<Integer>();

	for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
	    if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
	    {
		primes.add(i);
		if(1l * i * i <= N)
		    for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
			isComposite[j] = 1;
	    }   
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve(1120);
	while(true){
	    n = bf.nextInt(); k = bf.nextInt();
	    if(n == 0 && k == 0)
		break;
	    memo = new int[n+1][188][k+1];
	    for (int i = 0; i < memo.length; i++)
		for (int j = 0; j < memo[i].length; j++)
		    Arrays.fill(memo[i][j], -1);
	    out.println(dp(0,0,k));
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
