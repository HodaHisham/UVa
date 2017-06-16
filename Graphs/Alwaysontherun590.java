package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alwaysontherun590 {
    static ArrayList<Integer> [][] mat;
    static int [][] memo;
    static int INF = (int) 1e9 , k;
    public static int dp(int ind, int days){
	if(days == k)
	    return ind == mat.length-1?0:INF;
	if(days > k)
	    return INF;
	if(memo[ind][days] != -1)
	    return memo[ind][days];
	int ans = INF;
	for (int i = 0; i < mat.length; i++)
	{
	    if(mat[ind][i].size() > 0){
		int price = mat[ind][i].get(days%mat[ind][i].size());
		if(price > 0){
		    int tmp = dp(i,days+1);
		    if(tmp < INF)
			ans = Math.min(ans,price+tmp);
		}
	    }
	}
	return memo[ind][days] = ans;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    int n = bf.nextInt();
	    k = bf.nextInt();
	    if(n == 0 && k == 0)
		break;
	    mat = new ArrayList[n][n];
	    for (int i = 0; i < mat.length; i++)
	    {
		for (int j = 0; j < mat.length; j++)
		{
		    mat[i][j] = new ArrayList<Integer>();
		    if(i == j)
			continue;
		    int p = bf.nextInt();
		    for (int l = 0; l < p; l++)
		    {
			mat[i][j].add(bf.nextInt());
		    }
		}
	    }
	    memo = new int[n+1][k+1];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    int ans = dp(0,0);
	    out.println("Scenario #"+cases++);
	    out.println(ans == INF?"No flight possible.":"The best flight costs "+ans +".");
	    out.println();
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

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
    }
}
