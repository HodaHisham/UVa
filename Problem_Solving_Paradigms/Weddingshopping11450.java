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

public class Weddingshopping11450 {

    static int [][] gar,memo;
    static int m,c;
    public static int dp(int sum, int ind){
	if(ind == c)
	    return sum;
	if(memo[sum][ind] != -1)
	    return memo[sum][ind];
	int ans = 0;
	for (int i = 0; i < gar[ind].length; i++)
	{
	    if(gar[ind][i] + sum <= m)
		ans = Math.max(ans, dp(sum + gar[ind][i],ind+1));
	}
	return memo[sum][ind] = ans;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    m = bf.nextInt(); c = bf.nextInt();
	    gar = new int [c][];
	    memo = new int[m+1][c+1];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    for (int i = 0; i < c; i++)
	    {
		int k = bf.nextInt();
		gar[i] = new int[k];
		for (int j = 0; j < k; j++)
		{
		    gar[i][j] = bf.nextInt();
		}
	    }
	    int ans = dp(0,0);
	    out.println(ans==0?"no solution":ans);
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
