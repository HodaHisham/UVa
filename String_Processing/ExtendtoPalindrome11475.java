package Strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExtendtoPalindrome11475 {
    static int [] prefix(char [] s)
    {
	int n = s.length; 
	int [] pi = new int[n];
	for (int i = 1, j = 0; i < pi.length; i++)
	{
	    while(j > 0 && s[i] != s[j])
		j = pi[j-1];
	    if(s[i] == s[j])
		++j;
	    pi[i] = j;
	}
	return pi;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready())
	{
	    String s = bf.next();
	    int n = s.length();
	    int [] pi = prefix((new StringBuilder(s).reverse().append("&").append(s)).toString().toCharArray());
	    StringBuilder sb = new StringBuilder(s);
	    if(pi[2*n-1] < n)
		sb.append(new StringBuilder(sb.substring(0,n-pi[2*n-1]-1)).reverse());
	    out.println(sb);
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