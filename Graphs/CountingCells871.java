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

public class CountingCells871 {
    static char [][] grid;
    public static void dfs(int i ,int j){
	grid[i][j] = '0';
	for (int k = 0; k < dx.length; k++)
	{
//	    System.out.println(i+dx[k] + " " + (j+dy[k]) + " " + k);
	    if(isValid(i+dx[k], j+dy[k]))
	    {
		num++;
		dfs(i+dx[k],j+dy[k]);
	    }
	}
    }
    static int[] dx=  {1,0,-1 ,0,1,1,-1,-1};
    static int[] dy=  {0,1,0 ,-1,1,-1,1,-1};
    static int num;
    public static boolean isValid(int x, int y){
	return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == '1';		
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	bf.nextLine();
	while(t-->0){
	    ArrayList<String> arr = new ArrayList<String>();
	    while(true){
		String s = bf.nextLine();
		if(s == null || s.isEmpty())
		    break;
		arr.add(s);
	    }
	    grid = new char[arr.size()][arr.get(0).length()];
	    for (int i = 0; i < arr.size(); i++){
		grid[i] = arr.get(i).toCharArray();
//		out.println(Arrays.toString(grid[i]));
	    }
	    int ans = 0; 
	    for (int i = 0; i < grid.length; i++)
	    {
		for (int j = 0; j < grid[i].length; j++)
		{
		    if(grid[i][j] == '1'){
			num = 1;
//			System.out.println("Starting" + i+" " +j);
			dfs(i,j);
//			System.out.println();
			ans = Math.max(ans, num);
		    }
		}
	    }
//	    System.out.println("End");
	    out.println(ans);
	    if(t > 0)
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
