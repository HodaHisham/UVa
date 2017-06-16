package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumSum108 {



    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int n = bf.nextInt();
	    int [][] mat  = new int[n][n];
	    for (int i = 0; i < mat.length; i++)
	    {
		for (int j = 0; j < mat.length; j++)
		{
		    mat[i][j] = bf.nextInt() + (i>0?mat[i-1][j]:0) + (j>0 ?mat[i][j-1]:0)-(i>0 && j>0?mat[i-1][j-1]:0);
		}
	    }
	   
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < mat.length; i++)
	    {
		for (int j = 0; j < mat.length; j++)
		{
		    for (int j2 = i; j2 < mat.length; j2++)
		    {
			for (int k = j; k < mat.length; k++)
			{
			    max = Math.max(max, mat[j2][k]-(j>0?mat[j2][j-1]:0)-(i>0?mat[i-1][k]:0)+(i>0&& j>0?mat[i-1][j-1]:0));
			}
		    }
		}
	    }
	    out.println(max);
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
