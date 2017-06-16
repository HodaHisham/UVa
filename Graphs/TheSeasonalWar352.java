package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheSeasonalWar352 {
    static char [][] grid;
    static int dx [] = {1,0,-1,0,1,1,-1,-1};
    static int dy [] = {0,1,0,-1,1,-1,1,-1};
    public static void dfs(int r,int c){
	grid[r][c] = '0';
	for (int i = 0; i < dx.length; i++)
	{
	    int rx = r + dx[i], ry = c+ dy[i];
	    if(isValid(rx, ry))
		dfs(rx,ry);
	}
    }
    public static boolean isValid(int r ,int c){
	return r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] == '1';
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(bf.ready()){
	    int n = bf.nextInt();
	    grid = new char[n][n];
	    for (int i = 0; i < n; i++)
	    {
		grid[i] = bf.next().toCharArray();
	    }
	    int ans = 0;
	    for (int i = 0; i < grid.length; i++)
	    {
		for (int j = 0; j < grid.length; j++)
		{
		    if(grid[i][j] == '1'){
			dfs(i,j);
			ans++;
		    }
		}
	    }
	    out.println("Image number " + cases++ + " contains " + ans + " war eagles.");
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
