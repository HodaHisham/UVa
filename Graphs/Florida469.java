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

public class Florida469 {

    static char [][] grid;
    static int [] dx = {1,0,-1,0,1,-1,1,-1};
    static int [] dy = {0,1,0,-1,1,-1,-1,1};
    public static int dfs(int r, int c){
	if(grid[r][c] != 'W')
	    return 0;
	grid[r][c] = '.';
	int ans = 1;
	for (int i = 0; i < dx.length; i++)
	{
	    if(valid(r+dx[i],c+dy[i]))
		ans += dfs(r+dx[i],c+dy[i]);
	}
	return ans;
    }
    public static boolean valid(int r, int c){
	return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'W';
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	for (int k = 0; k < t; k++)
	{
	    if(k == 0)
		bf.nextLine();
	    ArrayList <char[]> tmp= new ArrayList<char[]>();
	    String s = "";
	    while(!Character.isDigit((s = bf.nextLine()).charAt(0))){
		tmp.add(s.toCharArray());
	    }
	    int n = tmp.size(), m = tmp.get(0).length;
	    grid = new char[n][m];
	    char [][] org = new char[n][m];
	    for (int i = 0; i < n; i++)
		org[i] = tmp.get(i);
	    while(true){
		if(s == null || s.isEmpty() || !Character.isDigit(s.charAt(0)))
		    break;
		StringTokenizer st = new StringTokenizer(s);
		int i = Integer.parseInt(st.nextToken())-1, j = Integer.parseInt(st.nextToken())-1;
		for (int j2 = 0; j2 < org.length; j2++)
		    grid[j2] = Arrays.copyOf(org[j2], m);
		out.println(dfs(i,j));
		if(bf.ready())
		    s = bf.nextLine();
		else
		    break;
	    }
	    if(k < t-1)
		out.println();
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