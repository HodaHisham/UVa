package Strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Compromise531 {
    static int [][] memo;
    static ArrayList<String>s,t,res;
    public static int dp(int i, int j){
	if(i == s.size() || j == t.size())
	    return 0;
	if(memo[i][j] != -1)
	    return memo[i][j];
	int ans = Math.max(dp(i,j+1), dp(i+1,j));
	if(s.get(i).equals(t.get(j)))
	    ans = Math.max(ans, 1+dp(i+1,j+1));
	return memo[i][j] = ans;
    }
    public static void print(int i, int j){
	if(i == s.size() || j == t.size())
	    return;
	int ans = dp(i,j);
	if(s.get(i).equals(t.get(j)) && ans == dp(i+1,j+1)+1)
	{
	    res.add(s.get(i));	
	    print(i+1,j+1);
	}
	else if(ans == dp(i,j+1))
	    print(i,j+1);
	else print(i+1,j);
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    s = new ArrayList<String>();
	    t = new ArrayList<String>();
	    res = new ArrayList<String>();
	    while(true)
	    {
		String tmp = bf.next();
		if(tmp.equals("#")) break;
		s.add(tmp);
	    }
	    while(true)
	    {
		String tmp = bf.next();
		if(tmp.equals("#")) break;
		t.add(tmp);
	    }
	    memo = new int[s.size()][t.size()];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    //	    for (int i = 1; i < dp.length; i++)
	    //	    {
	    //		for (int j = 1; j < dp[i].length; j++)
	    //		{
	    //		    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	    //		    if(s.get(i).equals(t.get(j)))
	    //			dp[i][j] = Math.max(dp[i][j], 1+dp[i-1][j-1]);
	    //		}
	    //	    }
	    //	    int i = s.size(), j = t.size();
	    //	    while(i >= 0 && j >= 0){
	    //		if(dp[i][j] == dp[i-1][j-1]+1)
	    //		    res.push(item)
	    //		    
	    //	    }
	    dp(0,0);
	    print(0, 0);
	    for (int i = 0; i < res.size(); i++)
	    {
		if(i > 0) out.print(" ");
		out.print(res.get(i));
		
	    }
	    out.println();
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
