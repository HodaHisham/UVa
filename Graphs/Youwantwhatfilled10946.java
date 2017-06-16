package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Youwantwhatfilled10946 {
    static char [][] grid;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int count;
    public static boolean isValid(int x , int y, char c){
	return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == c;
    }
    public static int dfs(int i, int j){
	char tmp = grid[i][j];
	grid[i][j] = '.';
	int ans = 1;
	for (int k = 0; k < dx.length; k++)
	{
	    if(isValid(i+dx[k], j+dy[k],tmp))
		ans += dfs(i+dx[k],j+dy[k]);
	}
	return ans;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    int x = bf.nextInt(), y = bf.nextInt();
	    if(x == 0 && y == 0)
		break;
	    grid = new char[x][y];
	    for (int i = 0; i < grid.length; i++)
	    {
		grid[i] = bf.next().toCharArray();
	    }
	    ArrayList<Pair> ans = new ArrayList<Pair>();
	    for (int i = 0; i < grid.length; i++)
	    {
		for (int j = 0; j < grid[i].length; j++)
		{
		    if(grid[i][j] != '.')
			ans.add(new Pair(grid[i][j], dfs(i,j)));
		}
	    }
	    Collections.sort(ans);
	    out.println("Problem " + cases++ + ":");
	    for (int j = 0; j < ans.size(); j++)
	    {
		out.println(ans.get(j));
	    }
	}
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int val; char num;
	public Pair(char n, int v){
	    val = v; num = n;
	}
	@Override
	public int compareTo(Pair o)
	{
	    if(val == o.val)
		return num - o.num;
	    return o.val - val;
	}
	public String toString(){
	    return num + " " + val;
	}
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
