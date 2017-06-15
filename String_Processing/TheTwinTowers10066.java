package Strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheTwinTowers10066 {



    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    int n1 = bf.nextInt(), n2 = bf.nextInt();
	    if(n1 == 0 && n2 == 0) break;
	    String [] s = new String[n1];
	    String [] t = new String[n2];
	    for (int i = 0; i < s.length; i++)
	    {
		s[i] = bf.next();
	    }
	    for (int i = 0; i < t.length; i++)
	    {
		t[i] = bf.next();
	    }
	    int [][] dp = new int[n1+1][n2+1];
	    for (int i = 1; i < dp.length; i++)
	    {
		for (int j = 1; j < dp[i].length; j++)
		{
		    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		    if(s[i-1].equals(t[j-1]))
			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
		}
	    }
	    out.println("Twin Towers #" + cases++);
	    out.println("Number of Tiles : "+dp[n1][n2]);
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
