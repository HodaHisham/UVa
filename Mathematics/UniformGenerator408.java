package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UniformGenerator408 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    //	    while(true){
	    int s = bf.nextInt(), m = bf.nextInt();
	    //		if(s + m == 0) break;
	    boolean [] b = new boolean[m];
	    int p = 0;
	    for (int i = 0; i < m; i++)
	    {
		b[(p+s)%m] = true;
		p = (p+s)%m;
	    }
	    boolean flag = true;
	    for (int i = 0; i < b.length && flag; i++)
	    {
		if(!b[i])
		    flag = false;
	    }
	    out.printf("%10d%10d    %s\n\n", s,m, flag?"Good Choice":"Bad Choice");
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