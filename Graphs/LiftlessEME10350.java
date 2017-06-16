package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LiftlessEME10350 {
    static int [][] mat;
    static int [][] memo;
    static int INF = (int) 1e9 , n, m;
    public static int dp(int f, int h){
	if(f == n)
	    return 0;
	if(memo[f][h] != -1)
	    return memo[f][h];
	int ans = INF;
	for (int i = 0; i < m; i++)
	{
	    ans = Math.min(ans, 2+mat[f*m+h][i]+dp(f+1,i));
	}
	return memo[f][h] = ans;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    String name = bf.next();
	     n = bf.nextInt()-1;
	     m = bf.nextInt();
	    mat = new int[m*n][m];
	    for (int k = 0; k < n; k++)
	    {
		for(int i = 0; i < m; i++)
		    for (int j = 0; j < m; j++)
		    {
			mat[k*m+i][j] = bf.nextInt();
		    }
	    }
	    memo = new int[n+1][m+1];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    out.println(name);
	    int ans = INF;
	    for (int i = 0; i < m; i++)
	    {
		ans = Math.min(ans, dp(0,i));
	    }
	    out.println(ans);
	}
	out.flush();
	out.close();
    }

    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{    br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public String nextLine() throws IOException {return br.readLine();}
	
	public boolean ready() throws IOException{ return br.ready();}
    }
}
