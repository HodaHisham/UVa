package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Unixls400 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready())
	{	
	    int n = bf.nextInt();
	    for (int i = 0; i < 60; i++)
	    {
		out.print('-');
	    }
	    out.println();
	    String [] s = new String[n];
	    int max = 0;
	    for (int i = 0; i < s.length; i++)
	    {
		s[i] = bf.next();
		max = Math.max(max, s[i].length());
	    }
	    Arrays.sort(s);
	    int c = (60-max)/(max+2)+1, r = n/c + (n%c==0?0:1);
	    int count = 0;
	    for (int i = 0; i < r; i++)
	    {
		count = i;
		for (int j = 0; j < c; j++)
		{
		    if(count >= n)
			break;
		    out.print(s[count]);
		    int sz = max + (j < c-1 && count + r <n?2:0);
			for (int k = s[count].length(); k < sz; k++)
			{
			    out.print(" ");
			}
		    count += r;
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