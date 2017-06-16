package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeSumming112 {
    static Scanner bf;
    static char [] s;
    static int idx;
    public static int build(int val) throws IOException
    {
	while(true)
	{
	    if(s == null || idx == s.length)
	    { 
		s = bf.next().toCharArray();
		idx = 0;
	    }
	    if(s[idx] == '(')
		break;
	    idx++;
	}
	idx++;
	StringBuilder sb = new StringBuilder();
	while(true)
	{
	    if(s == null || idx == s.length)
	    { 
		s = bf.next().toCharArray();
		idx = 0;
	    }
	    if(!(Character.isDigit(s[idx]) || s[idx] == '-'))
		break;
	    sb.append(s[idx]);
	    idx++;
	}
	if(s[idx] == ')'){
	    idx++;
	    return (val==0?2:0);
	}
	else{
//	    System.out.println(Arrays.toString(s) + " " + idx);
	    int num = Integer.parseInt(sb.toString());
	    int a = build(val-num);
	    int b = build(val-num);
	    while(true)
	    {
		if(s == null || idx == s.length)
		{ 
		    s = bf.next().toCharArray();
		    idx = 0;
		}
		if(s[idx] == ')')
		    break;
		idx++;
	    }
	    idx++;
	    return a == 3 || b == 3?3:a == 2 && b == 2?3:1;
	}
    }
    public static void main(String[] args) throws Exception
    {
	bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready())
	{
	    out.println(build(bf.nextInt())==3?"yes":"no");
	}
	out.flush();
	out.close();
    }
    static class Node
    {
	int val; 
	Node r,l;
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