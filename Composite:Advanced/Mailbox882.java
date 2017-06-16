package PSParadigms;  

import java.io.*;
import java.util.*;

public class Mailbox882{
    static int memo[][][], INF = (int)1e9;

    public static int dp(int min, int max, int left){
	if(min == max)
	     return 0;
	if(left == 0)
	    return INF;
	if(memo[min][max][left] != -1)
	    return memo[min][max][left];
	int ans = INF;
	for(int i = min+1; i <= max; i++){
	    ans = Math.min(ans, i+Math.max(dp(min,i-1,left-1), dp(i,max,left)));
	}
	return memo[min][max][left] = ans;
    }
    //memo = new int[101][101][11];
    // fill with -1
    //for every k,m call dp(0,m,k)
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	memo = new int[101][101][11];
	for (int i = 0; i < memo.length; i++)
	{
	    for(int j = 0; j < memo[i].length; j++){
		Arrays.fill(memo[i][j], -1);
	    }
	}
	int t = bf.nextInt();
	while(t-- > 0){
	    int k = bf.nextInt();
	    int m = bf.nextInt();
	    out.println(dp(0,m,k));
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