package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PreInPost10701 {
    static StringBuilder sb;
    static char [] pre;
    static HashMap<Character, Integer> mp;
    static void post(int s, int f){
	if(s > f)
	    return;
	int r = s+1;
	for(; r <= f; r++)
	    if(mp.get(pre[r]) > mp.get(pre[s]))
		break;
	post(s+1,r-1);
	post(r,f);
	sb.append(pre[s]);
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int c = bf.nextInt();
	while(c-->0){
	    int n = bf.nextInt();
	    mp = new HashMap<>();
	    pre = bf.next().toCharArray();
	    char [] in = bf.next().toCharArray();
	    for (int i = 0; i < in.length; i++)
	    {
		mp.put(in[i], i);
	    }
	    sb = new StringBuilder();
	    post(0,n-1);
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