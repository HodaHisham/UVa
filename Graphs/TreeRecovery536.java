package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TreeRecovery536 {
    static StringBuilder sb;
    static int [] in;
    static char [] pre;
    public static void print(int p, int e){
	if(p+1 >= e){
	    if(p < e)
		sb.append(pre[p]);
	    return;
	}
	int r = p+1;
	for (; r < e && in[pre[r]-'A'] <= in[pre[p]-'A']; r++);
	print(p+1,r);
	print(r,e);
	sb.append(pre[p]);
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready())
	{
	    pre = new char[26];
	    in = new int[26];
	    pre = bf.next().toCharArray();
	    char [] c = bf.next().toCharArray();
	    for (int i = 0; i < c.length; i++)
	    {
		in[c[i]-'A'] = i;
	    }
	    sb = new StringBuilder();
	    print(0,pre.length);
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