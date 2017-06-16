package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class RankLanguages10336 {
    static char [][] grid;
    static HashMap<Character,Integer> mp;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int count;
    public static boolean isValid(int x , int y, char c){
	return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == c;
    }
    public static void dfs(int i, int j){
	char tmp = grid[i][j];
	grid[i][j] = '.';
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
	int t = bf.nextInt();
	for (int k = 1; k <= t; k++)
	{
	    out.println("World #" + k);
	    int r = bf.nextInt();
	    int c = bf.nextInt();
	    grid = new char[r][c];
	    for (int i = 0; i < r; i++)
		grid[i] = bf.nextLine().toCharArray();
	    mp = new HashMap<Character,Integer>();
	    count = 1;
	    for (int i = 0; i < r; i++)
	    {
		for (int j = 0; j < c; j++)
		{
		    if(grid[i][j] != '.'){
			Integer in = mp.get(grid[i][j]);
			mp.put(grid[i][j],in==null?1:in+1);
			dfs(i,j);
		    }
		}
	    }
	    Pair [] p = new Pair[mp.size()];
	    int ind = 0;
	    for(Entry<Character, Integer> e: mp.entrySet()){
		p[ind++] = new Pair(e.getKey(), e.getValue());
	    }
	    Arrays.sort(p);
	    for (int i = 0; i < p.length; i++)
	    {
		out.println(p[i].c + ": " + p[i].val);
	    }
	}
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int val; char c;
	public Pair(char c, int v){
	    val = v;
	    this.c = c;
	}
	public int compareTo(Pair o)
	{
	    if(val == o.val)
		return c - o.c;
	    return o.val - val;
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
