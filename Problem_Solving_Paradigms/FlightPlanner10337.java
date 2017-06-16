package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FlightPlanner10337 {

    static int x,memo[][],wind[][];
    static int INF = (int)1e9;
    public static int dp(int dist, int alt){
	if(dist == x)
	    return alt == 0?0:INF;
	if(alt > x-dist)
	    return INF;
	if(memo[dist][alt] != -1)
	    return memo[dist][alt];
	int ans = 30 + dp(dist+1,alt);
	ans = Math.min(ans, INF);
	if(alt > 0)
	    ans = Math.min(ans, 20 + dp(dist+1,alt-1));
	ans = Math.min(ans, INF);
	if(alt < 9)
	    ans = Math.min(ans, 60 + dp(dist+1,alt+1));
	ans = Math.min(-wind[alt][dist] + ans, INF);
	return memo[dist][alt] = ans;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    x = bf.nextInt()/100;
	    memo = new int[x+1][10];
	    wind = new int[10][x];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    for (int i = 9; i >= 0; i--)
	    {
		for (int j = 0; j < x; j++)
		{
		    wind[i][j] = bf.nextInt();
		}
	    }
	    
	    out.println(dp(0,0));
	    out.println();
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
