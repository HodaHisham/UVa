package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HistoryGrading111 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	int [] events = new int[n];
	for (int i = 0; i < n; i++)
	{
	    events[bf.nextInt()-1] = i+1;
	}
	while(bf.ready()){
	    int [] stud = new int[n];
	    for (int i = 0; i < stud.length; i++)
	    {
		stud[bf.nextInt()-1] = i+1;
	    }
//	    out.println(Arrays.toString(events));
//	    out.println(Arrays.toString(stud));
	    int [][] dp = new int[n+1][n+1];
	    for (int i = 1; i < dp.length; i++)
	    {
		for (int j = 1; j < dp.length; j++)
		{
		    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		    if(stud[i-1] == events[j-1])
			dp[i][j] = Math.max(dp[i][j],1 + dp[i-1][j-1]);

		}
	    }
	    out.println(dp[n][n]);
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
