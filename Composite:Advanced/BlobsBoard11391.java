package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BlobsBoard11391 {
    static int[][] memo;
    static int r,c,n;
    static int [] dx = {1,-1,0,0,1,1,-1,-1};
    static int [] dy = {0,0,1,-1,1,-1,-1,1};
    public static int dp(int jump, int mask){
	if(jump == n)
	    if(Integer.bitCount(mask) != 1)
		return 1;
	    else return 0;
	if(Integer.bitCount(mask) == 1)
	    return 1;
	if(memo[jump][mask] != -1)
	    return memo[jump][mask];
	int ans = 0;
	int row = 0;
	int col = 0;
	for (int i = 0; (1<<i) <= mask; i++)
	{
	    if(((1<<i) & mask) != 0){
		for (int j = 0; j < dx.length; j++)
		{
		    if(isValid(row+(dy[j]<<1),col+(dx[j]<<1)) && (mask & (1 << ((row+(dy[j]<<1))*c+(col+(dx[j]<<1))))) == 0 && (mask & (1 << ((row+dy[j])*c+(col+dx[j])))) != 0){
			int tmp = ((mask ^ (1 << ((row+(dy[j]<<1))*c+(col+(dx[j]<<1)))))^ (1 << ((row+dy[j])*c+(col+dx[j]))))^(1 << (row*c+col));
//			System.out.println(row + " " + col + " " + j + " "+Integer.toBinaryString(mask) + " " + Integer.toBinaryString(tmp));
			ans += dp(jump+1,tmp);
		    }
		}
	    }
	    col++;
	    if(col == c){
		col = 0;
		row++;
	    }
	}
	return memo[jump][mask] = ans;
    }
    public static boolean isValid(int row,int col)
    {
	return row >= 0 && row < r && col >= 0 && col < c;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	for (int k = 1; k <= t; k++)
	{
	    r = bf.nextInt();
	    c = bf.nextInt();
	    n = bf.nextInt();
	    int mask = 0;
	    memo = new int[n][1<<(r*c)];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    for (int i = 1; i <= n; i++)
	    {
		int x = bf.nextInt()-1;
		int y = bf.nextInt()-1;
		mask |= (1 << (x*c+y));
	    }
	    System.out.println("Case " + k + ": " + (dp(0,mask)));
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
