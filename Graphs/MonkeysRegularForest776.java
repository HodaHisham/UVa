package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MonkeysRegularForest776 {

    static int [] dx = {1,0,-1,0,1,1,-1,-1};
    static int [] dy = {0,1,0,-1,1,-1,1,-1};
    static int count;
    static char[][]grid;
    static int[][]ans;
    public static boolean isValid(int x , int y, char c){
	return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == c;
    }
    public static void dfs(int i, int j){
	char tmp = grid[i][j];
	grid[i][j] = '.';
	ans[i][j] = count;
	for (int k = 0; k < dx.length; k++)
	{
	    if(isValid(i+dx[k], j+dy[k],tmp))
		dfs(i+dx[k],j+dy[k]);
	}

    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	String line = "";
	while(bf.ready()){
	    ArrayList<String[]> tmp = new ArrayList<String[]>();
	    while((line = bf.nextLine())!= null && !line.equals("%")){
		tmp.add(line.split(" "));
	    }
	    grid = new char[tmp.size()][tmp.get(0).length];
	    ans = new int[tmp.size()][tmp.get(0).length];
	    for (int j = 0; j < grid.length; j++)
	    {
		for (int k = 0; k < grid[j].length; k++)
		{
		    grid[j][k] = tmp.get(j)[k].charAt(0);
		}
	    }
	    count = 1;
	    for (int j = 0; j < grid.length; j++)
	    {
		for (int k = 0; k < grid[j].length; k++)
		{
		    if(grid[j][k] != '.'){
			dfs(j,k);
			count++;
		    }
		}
	    }
	    int [] max = new int[grid[0].length];
	    for (int i = 0; i < grid[0].length; i++)
	    {
		for (int j = 0; j < grid.length; j++)
		{
		    max[i] = Math.max(max[i], ans[j][i]);
		}
		max[i] = (""+max[i]).length();
	    }
	    for (int j = 0; j < ans.length; j++)
	    {
		for (int i = 0; i < ans[0].length; i++)
		{
		    if(i!=0) out.print(" ");
		    int min = max[i]-((""+ans[j][i]).length());
		    for (int k = 0; k < min; k++)
			out.print(" ");
		    out.print(ans[j][i]);
		}
		out.println();
	    }
	    out.println("%");
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
