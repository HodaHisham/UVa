package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LetMeCountTheWays35 { //change loop to eof

    static long [][] memo;
    static int [] coins = {1,5,10,25,50};
    public static long dp(int sum, int ind){
	if(sum == 0)
	    return 1;
	if(ind == coins.length)
	    return 0;
	if(memo[sum][ind] != -1)
	    return memo[sum][ind];
	long ans = 0;
	if(sum - coins[ind] >= 0)
	    ans += dp(sum-coins[ind],ind);
	ans += dp(sum,ind+1);
	return memo[sum][ind] = ans;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	memo = new long[30000+1][5];
	for (int i = 0; i < memo.length; i++)
	{
	    Arrays.fill(memo[i], -1);
	}
	for (int i = 0; i < memo.length; i++)
	{
	    dp(i,0);
	}
	while(bf.ready()){
	    int n = bf.nextInt();
	    long ans = dp(n,0);
	    if(ans == 1)
		out.println("There is only 1 way to produce "+n+" cents change.");
	    else
		out.println("There are "+ans+" ways to produce "+n+" cents change.");
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
