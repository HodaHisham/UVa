package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AMultiplicationGame847 {


    public static void main(String[] args) throws Exception
    {
//	Scanner bf = new Scanner(System.in);
	Scanner bf = new Scanner(new FileReader("A.txt"));
	PrintWriter out = new PrintWriter(System.out);
	StringBuilder sb = new StringBuilder();
	while(bf.ready()){
	    long n = bf.nextLong(), tmp = 1;
	    int i = 1;
	    while(true){
		if(tmp >= n)
		    break;
		i = (i+1)%2;
		tmp *= i == 0?9:2;
	    }
	    out.println(i == 0?"Stan wins.":"Ollie wins.");
	}
	out.print(sb);
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