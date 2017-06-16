package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Trouble13Dots10819 {
    static int n,m;
    static Pair[] items;
    static int [][] memo;
    public static int dp(int ind, int sum){
	if(ind == n){
	    return sum <= 2000 && sum <= m?0:sum > 2000 && sum <= m+200?0:-2;
	}
	if(sum > Math.max(m,2000)+200)
	    return -2;
	if(memo[ind][sum] != -1)
	    return memo[ind][sum];
	int leave = dp(ind+1,sum);
	int take = dp(ind+1,items[ind].p+sum);
	if(take != -2) take += items[ind].f;
	return memo[ind][sum] = Math.max(leave,take);
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    m = bf.nextInt();
	    n = bf.nextInt();
	    items = new Pair[n];
	    memo = new int[n+1][Math.max(m, 2000)+300];
	    for (int i = 0; i < memo.length; i++)
		Arrays.fill(memo[i], -1);
	    for (int i = 0; i < n; i++)
		items[i] = new Pair(bf.nextInt(), bf.nextInt());
	    out.println(dp(0,0));
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int p; int f;
	public Pair(int x,int y){
	    p = x;
	    f = y;
	}
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
