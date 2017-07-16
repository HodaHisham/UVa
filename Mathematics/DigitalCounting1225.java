package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DigitalCounting1225 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int [][] d = new int[10000][10];
	for (int i = 1; i < 10000; i++)
	{
	    for (int j = 0; j < 10; j++)
	    {
		d[i][j] = d[i-1][j];
	    }	  
	    int tmp = i;
	    while(tmp > 0){
		d[i][tmp%10]++;
		tmp /= 10;
	    }
	}
	int TC = bf.nextInt();
	while(TC-->0){
	    int n = bf.nextInt();
	    for (int i = 0; i < 9; i++)
	    {
		out.print(d[n][i] + " ");
	    }
	    out.println(d[n][9]);
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