package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StickerCollectorRobot11831 {
    static char[][]grid;
    static int stick, point;
    static char [] ins;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public static void dfs(int r, int c, int dir){
	if(grid[r][c] == '*')
	{
	    stick++; grid[r][c] = '.';
	}
	if(point == ins.length) return;
	if(ins[point] == 'F'){
	    point++;
	    if(isValid(r+dx[dir], c+dy[dir])){
		dfs(r+dx[dir], c+dy[dir],dir);
	    }
	    else
		dfs(r,c,dir);

	}
	else if(ins[point] == 'D'){
	    point++;
	    dfs(r,c,dir==0?3:dir==1?0:dir==2?1:2);
	}
	else{
	    point++;
	    dfs(r,c,dir==0?1:dir==1?2:dir==2?3:0);
	}
    }
    public static boolean isValid(int r, int c){
	return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != '#';
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt(), m = bf.nextInt(), s = bf.nextInt();
	    if(n == 0 && m == 0 && s == 0)
		break;
	    grid = new char[n][m];
	    for (int i = 0; i < grid.length; i++)
		grid[i] = bf.next().toCharArray();
	    stick = 0; int a = 0, b = 0; int d = '.';
	    for (int i = 0; i < grid.length; i++)
	    {
		for (int j = 0; j < grid[0].length; j++)
		{
		    if(grid[i][j] == 'N' || grid[i][j] == 'S' || grid[i][j] == 'L' || grid[i][j] == 'O')
		    {
			a = i; b = j; d = grid[i][j]=='N'?2:grid[i][j]=='S'?0:grid[i][j]=='L'?1:3;
			grid[i][j] = '.';
			break;
		    }
		}
	    }
	    ins = bf.next().toCharArray();
	    point = 0;
	    dfs(a,b,d);
	    out.println(stick);
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
