package Strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PrinceandPrincess10635 {


    static int lis(int[] A, int n)		// Can be implemented with TreeSet (lower, remove, add)
    {
	ArrayList<Integer> L = new ArrayList<Integer>(); 
	int lis = 0;
	for(int i = 0; i < n; ++i) 
	{
	    int pos = Collections.binarySearch(L, A[i]);
	    if (pos < 0) pos = -(pos + 1);
	    //			 else	pos++;		non-decreasing

	    if(pos >= L.size()) L.add(A[i]);
	    else                 L.set(pos, A[i]);

	    if(pos + 1 > lis)
	    {
		lis = pos + 1;
	    } 
	}
	return lis;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	for (int i = 1; i <= TC; i++)
	{
	     bf.nextInt(); int p = bf.nextInt(), q = bf.nextInt();
	    int [] s = new int[p+1];
	    int [] t = new int[q+1];
	    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
	    for (int j = 0; j < s.length; j++)
	    {
		s[j] = bf.nextInt();
		map.put(s[j], j);
	    }
	    int count = 0;
	    for (int j = 0; j < t.length; j++)
	    {
		int inp = bf.nextInt();
		Integer tmp = map.get(inp);
		if(tmp != null)
		    t[count++] = tmp;
	    }
	    //	    for (int j = 1; j < dp.length; j++)
	    //	    {
	    //		for (int k = 1; k < dp[j].length; k++)
	    //		{
	    //		    dp[j][k] = Math.max(dp[j-1][k], dp[j][k-1]);
	    //		    if(s[j-1] == t[k-1])
	    //			dp[j][k] = Math.max(dp[j][k], dp[j-1][k-1]+1);
	    //		}
	    //	    }
	    
	   out.println("Case "+i+": "+lis(t,q+1));
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
