package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Lights10309 {
    static int [][] mat;
    static final int INF = (int)1e9;
    static int ans;
    
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    String name = bf.nextLine();
	    if(name.equals("end"))
		break;
	    mat = new int[10][10];
	    for (int i = 0; i < 10; i++)
	    {
		String s = bf.next();
		for (int j = 0; j < 10; j++)
		{
		    mat[i][j] = s.charAt(j)=='O'?1:0;
		}
	    }
	    ans = INF;
	    for(int k = 0; k < 1024; k++){

		int [][] grid = new int[10][10];
		for(int i = 0; i<10; i++)
		    grid[i] = Arrays.copyOf(mat[i], 10);
		for (int i = 0; i < grid.length; i++)
		{
		    if((k & (1<<i)) != 0){
			grid[0][i] ^= 1;
			grid[1][i] ^= 1;
			if(i > 0)
			    grid[0][i-1] ^= 1;
			if(i < 9)
			    grid[0][i+1] ^= 1;
		    }
		}
		int res = Integer.bitCount(k);
		for (int i = 1; i < 10; i++)
		{
		    for (int j = 0; j < grid.length; j++)
		    {
			if(grid[i-1][j] == 1){
			    res++;
			    grid[i][j] ^= 1;
			    if(j > 0)
				grid[i][j-1] ^= 1;
			    if(j < 9)
				grid[i][j+1] ^= 1;
			    if(i < 9)
				grid[i+1][j] ^= 1;
			}

		    }
		}
		boolean flag = true;
		for (int i = 0; i < grid.length; i++)
		{
		    if(grid[9][i] == 1){
			flag = false;
			break;
		    }
		}
		if(flag)
		    ans = Math.min(ans, res);
	    }
	    out.println(name + " " + (ans>=INF?-1:ans));
	}
	out.flush();
	out.close();
    }

    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{    br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
    }
}
