package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TermStrategy11341 {
    static int n,m,exams [][] ,memo [][];
    public static int dp(int c, int h){
	if(c == n)
	    return 0;
	if(memo[c][h] != -1)
	    return memo[c][h];
	int ans = -2;
	for (int i = 0; i < h-n+c+1;i++)
	{
	    if(exams[c][i] > 4 && h-i-1 >= 0)
	    {
		int tmp = dp(c+1,h-i-1);
		if(tmp > -2)
		    ans = Math.max(ans, exams[c][i]+tmp);
	    }
	}
	return memo[c][h] = ans;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    n = bf.nextInt(); m = bf.nextInt();
	    memo = new int[n+1][m+1];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    exams = new int[n][m];
	    for (int i = 0; i < exams.length; i++)
	    {
		for (int j = 0; j < exams[i].length; j++)
		{
		    exams[i][j] = bf.nextInt();
		}
	    }
	    int ans = dp(0,m);
	    if(ans == -2)out.println("Peter, you shouldn't have played billiard that much.");
	    else out.printf("Maximal possible average mark - %.2f.\n", (ans/(double)n));
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
