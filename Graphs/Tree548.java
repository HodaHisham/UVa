package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Tree548 
{
    static int [] in,post;
    static int n;
    static int min(int s, int f){
	if(s > f)
	    return (int)1e9;
	if(s == f)
	    return post[s];
	int l = 0;
	for (l = s; l < f; l++)
	{
	    if(in[post[l]] > in[post[f]])
		break;
	}
	
	return post[f] + Math.min(min(s,l-1),min(l,f-1));
    }
    static int get(int s, int f, int val){
	if(s > f)
	    return (int)1e9;
	if(s == f)
	    return (val == post[s]?post[s]:(int)1e9);
	int l = 0;
	for (l = s; l < f; l++)
	{
	    if(in[post[l]] > in[post[f]])
		break;
	}
	return Math.min(get(s,l-1,val-post[f]), get(l,f-1,val-post[f]));
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready())
	{
	    StringTokenizer tmp = new StringTokenizer(bf.nextLine());
	    in = new int[10000];
	    int i = 0;
	    while(tmp.hasMoreTokens())
	    {
		in[Integer.parseInt(tmp.nextToken())] = i++;
	    }
	    tmp = new StringTokenizer(bf.nextLine());
	    post = new int[tmp.countTokens()];
	    for (i = 0; i < post.length; i++)
	    {
		post[i] = Integer.parseInt(tmp.nextToken());
	    }
	    n = post.length;
	    out.println(get(0,n-1,min(0,n-1)));
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