package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FilltheSquare11520 {

    public static boolean valid(int x, int y, int n){
	return x >= 0 && y >= 0 && x < n && y < n;
    }
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	for (int k = 1; k <= TC; k++)
	{
	    int n = bf.nextInt();
	    char [][] grid = new char[n][n];
	    for (int i = 0; i < n; i++)
	    {
		grid[i] = bf.next().toCharArray();
	    }
	    for (int i = 0; i < grid.length; i++)
	    {
		for (int j = 0; j < grid.length; j++)
		{
		    if(grid[i][j] == '.'){
			char c = 'A';
			while(true){
			    boolean flag = true;
			    for (int l = 0; l < dx.length; l++)
			    {
				int tx = i + dx[l], ty = j+dy[l];
				if(valid(tx,ty,n) && grid[tx][ty] == c){
				    c++;
				    flag = false;
				}
			    }
			    if(flag) break;
			}
			grid[i][j] = c;
		    }
		}
	    }
	    out.println("Case "+k+":");
	    for (int i = 0; i < grid.length; i++)
	    {
		for (int j = 0; j < grid.length; j++)
		{
		    out.print(grid[i][j]);
		}
		out.println();
	    }
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
