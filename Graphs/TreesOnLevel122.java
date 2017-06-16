package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreesOnLevel122 { // change to eof 



    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int [] tree = new int[(int)1e7]; //1-based
	    Arrays.fill(tree, -2);
	    int max = 0;
	    boolean flag = true;
	    while(true){
		String line = bf.next();
		if(line.equals("()")) break;
		String [] s = line.substring(1,line.length()-1).split(",");
		int node = 1;
		if(s.length > 1){
		    for (int i = 0; i < s[1].length(); i++)
		    {
			if(tree[node] == -2) tree[node] = -1;
			node = (node<<1)+(s[1].charAt(i)=='R'?1:0);
		    }
		}
		max = Math.max(max, node);
		if(tree[node] > -1) flag = false;
		tree[node] = Integer.parseInt(s[0]);
	    }
	    if(!flag){
		out.println("not complete");
	    }
	    else{
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= max; i++)
		{
		    if(tree[i] == -2)
			continue;
		    if(tree[i] == -1){
			flag = false;
			break;
		    }
		    if(i > 1) sb.append(" ");
		    sb.append(tree[i]);
		}
		if(!flag) out.println("not complete");
		else out.println(sb);
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
