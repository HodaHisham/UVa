package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Continents11094 {

    static char [][] grid;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int num;
    static char l;
    static int n,m;
    public static boolean isValid(int x , int y){
	return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == l;
    }
    public static void dfs(int i, int j){

	grid[i][j] = (char)(Math.max(0,l-1));
	num++;
	for (int k = 0; k < dx.length; k++)
	{
	    if(isValid(i+dx[k], (j+dy[k]+m)%m))
		dfs(i+dx[k],(j+dy[k]+m)%m);
	}

    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	String tmp = bf.nextLine();
	while(tmp != null){
	    StringTokenizer st = new StringTokenizer(tmp);
	    n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
	    grid = new char[n][m];
	    for (int i = 0; i < n; i++)
		grid[i] = bf.next().toCharArray();
	    int x = bf.nextInt(), y = bf.nextInt();
	    l = grid[x][y];
	    dfs(x,y);
	    int ans = 0;
	    for (int i = 0; i < n; i++)
	    {
		for (int j = 0; j < m; j++)
		{
		    if(grid[i][j] == l){
			num = 0;
			dfs(i,j);
			if(num > ans) ans = num;
		    }
		}
	    }
	    out.println(ans);
	    tmp = bf.nextLine();
	    while(tmp != null && tmp.isEmpty())
		tmp = bf.nextLine();
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
	    while (st == null || !st.hasMoreTokens()){
		st = new StringTokenizer(br.readLine());
	    }
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
