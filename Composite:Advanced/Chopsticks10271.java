package PSParadigms;  
import java.io.*;
import java.util.*;

public class Chopsticks10271{
    static int memo[][],val[];
    static int n;
    static int INF = (int)1e9;
    public static int dp(int ind, int k){
	if(k == 0)
	    return 0;
	if(ind == n)
	    return INF;
	if(memo[ind][k] != -1)
	    return memo[ind][k];
	int ans = dp(ind+1,k);
	if((n-ind) >= k*3)
	    ans = Math.min(ans, (val[ind]-val[ind+1])*(val[ind]-val[ind+1])+dp(ind+2,k-1));
	return memo[ind][k] = ans;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	while(t-- > 0){
	    int k = bf.nextInt();
	    n = bf.nextInt();
	    val = new int[n];
	    memo = new int[n+1][k+9];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    for (int i = 0; i < n; i++)
	    {
		val[i] = bf.nextInt();
	    }
	    out.println(dp(0,k+8));
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