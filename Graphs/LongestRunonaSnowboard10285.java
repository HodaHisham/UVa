package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestRunonaSnowboard10285 {

    static int [][] grid;
    static int [][] memo;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int r,c;
    public static int dfs(int r, int c){
	if(memo[r][c] != -1)
	    return memo[r][c];
	int tmp = grid[r][c];
//	grid[r][c] = -1;
	int ans = 1;
	for (int i = 0; i < dx.length; i++)
	{
	    int tx = r+dx[i], ty = c + dy[i];
	    if(valid(tx,ty) && grid[tx][ty] < tmp)
		ans = Math.max(dfs(tx,ty)+1,ans);
	}
//	grid[r][c] = tmp;
	return memo[r][c] = ans;
    }
    public static boolean valid(int x, int y){
	return x >= 0 && x < r && y >= 0 && y < c && grid[x][y] != -1;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    String name = bf.next();
	    int ans = 0;
	     r = bf.nextInt(); c = bf.nextInt();
	    grid = new int[r][c];
	    memo = new int[r][c];
	    for (int i = 0; i < r; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    int [][] org = new int[r][c];
	    for (int i = 0; i < r; i++)
	    {
		for (int j = 0; j < c; j++)
		{
		    grid[i][j] = bf.nextInt();
		}
	    }
	    for (int i = 0; i < r; i++)
	    {
		for (int j = 0; j < c; j++)
		{
//		    grid = new int[r][c];
//		    for (int k = 0; k < org.length; k++)
//		    {
//			grid[k] = Arrays.copyOf(org[k], c);
//		    }
		    ans = Math.max(ans,dfs(i,j));
		}
	    }
	    out.println(name + ": " + ans);
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
