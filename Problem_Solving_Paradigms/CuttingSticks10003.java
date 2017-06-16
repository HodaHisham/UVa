package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CuttingSticks10003 {
    static int n, c[];
    static int memo[][];
    static final int INF = (int)1e9;
    public static int dp(int l, int r){
	if(r - l == 1)
	    return 0;
	if(memo[l][r] != -1)
	    return memo[l][r];
	int min = INF;
	for (int i = l+1; i <= r-1; i++)
	{
	    min = Math.min(min, dp(l,i)+dp(i,r)+c[r]-c[l] );
	}
	return memo[l][r] = min;
    }
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int l = bf.nextInt();
	    if(l == 0)
		break;
	    n = bf.nextInt();
	    c = new int[n+2];
	    for (int i = 1; i <= n; i++)
	    {
		c[i] = bf.nextInt(); 
	    }
	    c[n+1] = l;
	    memo = new int[n+3][n+3];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    out.println("The minimum cutting is " + dp(0,n+1)+".");
	}
	out.flush();
	out.close();
    }
    /** static class newType implements Comparable{
	int a;
	int b;
	public newType(int a,int b){
	    this.a = a;
	    this.b = b;

	}
	public int compareTo(newType t){
	    if(a != t.a)
		return a - t.a;
	    return b - t.b;

	}
    }**/
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
