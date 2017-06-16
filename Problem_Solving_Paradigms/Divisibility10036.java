package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Divisibility10036 {
    static int[][]memo;
    static int n,k, num[];
    public static int dp(int idx, int mod){
	if(idx == n){
	    return mod % k == 0?1:0;
	}
	if( memo[idx][mod] != -1)
	    return memo[idx][mod];

	return memo[idx][mod] = dp(idx+1,(mod+(num[idx]%k+k)%k)%k) | dp(idx+1,((mod-(num[idx]%k+k)%k)+k)%k);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int m = bf.nextInt();
	while(m-->0 ){
	    n = bf.nextInt();
	    k = bf.nextInt();
	    memo = new int[n+1][k];
	    num = new int[n];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    for (int i = 0; i < n; i++)
	    {
		num[i] = bf.nextInt();
	    }
	    int res = dp(1,(num[0]%k+k)%k);
	    out.println(res == 1?"Divisible" :"Not divisible");
	}
	out.flush();
	out.close();
    }
    /**
     * 2
4 7
17 5 -21 15
4 5
17 5 -21 15
     * @author Hoda
     *
     */
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

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
	}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}


    }
}
