package Misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RepeatedSubstitutionwithSed1251 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	StringBuilder sb = new StringBuilder();
	while (true)
	{
	    int n = bf.nextInt();
	    if (n == 0)
		break;
	    String[][] s = new String[n][2];
	    for (int i = 0; i < s.length; i++)
	    {
		for (int j = 0; j < s[i].length; j++)
		{
		    s[i][j] = bf.next();
		}
	    }
	    StringBuilder old = new StringBuilder(bf.next());
	    String goal = bf.next();
	    HashSet<String> set = new HashSet<>();
	    Queue<Pair> q = new LinkedList<>();
	    q.add(new Pair(old, 0));
	    int ans = -1;
	    while (!q.isEmpty())
	    {
		Pair st = q.poll();
		String tmp = st.sb.toString();
		if (tmp.equals(goal))
		{
		    ans = st.val;
		    break;
		}
		for (int i = 0; i < s.length; i++)
		{
		    StringBuilder build = new StringBuilder();
		    for (int k = 0; k < tmp.length() && build.length() <= goal.length(); k++)
		    {
			int t = k, j = 0;
			boolean flag = true;
			for (; flag && t < st.sb.length() && j < s[i][0].length(); j++, t++)
			{
			    if (s[i][0].charAt(j) != st.sb.charAt(t))
				flag = false;
			}
			if (flag && j == s[i][0].length())
			{
			    build.append(s[i][1]);
			    k += s[i][0].length() - 1;
			} else
			    build.append(st.sb.charAt(k));
		    }
		    if (build.length() > goal.length())
			continue;
		    if (!set.contains(build.toString()))
		    {
			q.add(new Pair(build, st.val + 1));
			set.add(build.toString());
		    }

		}
	    }
	    sb.append(ans).append("\n");
	}
	out.print(sb);
	out.flush();
	out.close();
    }

    static class Pair {
	StringBuilder sb;
	int val;

	public Pair(StringBuilder s, int v)
	{
	    sb = s;
	    val = v;
	}
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