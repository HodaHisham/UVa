package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MazeExploration784 {

    static char [][] grid;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public static void dfs(int r, int c){
	grid[r][c] = '#';
	for (int i = 0; i < dx.length; i++)
	{
	    if(valid(r+dx[i],c+dy[i]))
		dfs(r+dx[i],c+dy[i]);
	}
    }
    public static boolean valid(int r, int c){
	return r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == ' ';
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	String line = "";
	while(TC-->0){
	    ArrayList<char [] > inp = new ArrayList<char []>();
	    int x = -1, y = -1;
	    while((line = bf.nextLine()).charAt(0) != '_'){
		inp.add(line.toCharArray());
		for (int i = 0; i < line.length(); i++)
		{
		    if(line.charAt(i) == '*'){
			x = inp.size()-1; y = i;
			break;
		    }
		}
	    }
	    grid = new char[inp.size()][];
	    for (int i = 0; i < inp.size(); i++)
	    {
		grid[i] = inp.get(i);
	    }
	    inp.add(line.toCharArray());
	    dfs(x,y);
	    for (int i = 0; i < grid.length; i++)
	    {
		out.println(grid[i]);
	    }
	    out.println(inp.get(inp.size()-1));
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
