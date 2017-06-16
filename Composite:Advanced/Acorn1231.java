package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Acorn1231 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int c = bf.nextInt();
	while(c-- > 0){
	    int t = bf.nextInt(), h = bf.nextInt(), f = bf.nextInt();
	    int [][] acorn = new int[t][h+1];
	    for (int i = 0; i < t; i++)
	    {
		int n = bf.nextInt();
		for (int j = 0; j < n; j++)
		{
		    acorn[i][bf.nextInt()]++;
		}
	    }
	    int [] dp = new int[h+1];
	    for (int i = h; i >= 0; i--)
	    {
		for (int j = 0; j < t; j++)
		{
		    dp[i] = Math.max(dp[i], acorn[j][i]);
		}
	    }
	    for(int i = h-1; i >= 0; i--){
		for (int j = 0; j < t; j++)
		{
		    acorn[j][i] += Math.max(acorn[j][i+1], i + f <= h?dp[i+f]:0);
		    dp[i] = Math.max(dp[i], acorn[j][i]);
		}
	    }
	    out.println(dp[0]);
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
