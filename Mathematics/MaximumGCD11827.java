package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaximumGCD11827 {

    public static int gcd(int a, int b){
	return b == 0?a:gcd(b,a%b);
    }
    
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    StringTokenizer st = new StringTokenizer(bf.nextLine());
	    ArrayList<Integer>val = new ArrayList<Integer>();
	    while(st.hasMoreTokens())
	    {
		val.add(Integer.parseInt(st.nextToken()));
	    }
	    int max = 1;
	    for (int i = 0; i < val.size(); i++)
	    {
		for (int j = i+1; j < val.size(); j++)
		{
		    max = Math.max(max, gcd(val.get(i),val.get(j)));
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
