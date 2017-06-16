package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class TriTiling10918 {
    static int [][] memo;
    static int n;
    public static int dp(int col, int mask){
	if(col == 0) return 1;
	if(memo[col][mask] != -1)
	    return memo[col][mask];
	int count = 0;
	switch(mask){
	    case 0:
		if(col > 1)
		    count = dp(col-1,7) + dp(col-1,1) + dp(col-1,4);
		break;
	    case 1:
		count = dp(col-1,0);
		if(col > 1)
		    count += dp(col-1,6); 
		break;
	    case 3:
		if(col > 1)
		    count = dp(col-1,4);
		break;
	    case 4:
		count = dp(col-1,0);
		if(col > 1)
		    count += dp(col-1,3);
		break;
	    case 6:
		if(col > 1)
		    count = dp(col-1,1);
		break;
	    case 7:
		count = dp(col-1,0);
		break;
	}
	return memo[col][mask] = count;
    }
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	memo = new int[31][8];
	for (int i = 0; i < memo.length; i++)
	{
	    Arrays.fill(memo[i], -1);
	}
	while(true)
	{
	    n = bf.nextInt();
	    if(n == -1)
		break;
	    out.println(dp(n,0));
	}
	out.flush();
	out.close();
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if(x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for(int i = start; i < x.length(); i++)
		if(x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		}
		else
		{
		    sb.append(x.charAt(i));
		    if(dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg?-1:1);
	}

	public boolean ready() throws IOException {return br.ready();}
    }
}

