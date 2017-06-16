package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DivingForGold990{
    static int[] depth,quantity,td,ta;
    static int [][] memo;
    static int n,t,w;
    static ArrayList<Integer>res;
    public static int dp(int ind, int remCap){
	if(ind == n || remCap < 0)
	    return 0;
	if(memo[ind][remCap] != -1)
	    return memo[ind][remCap];
	int take = 0;
	if(remCap - (td[ind]+ta[ind]) >= 0){
	    take =  quantity[ind] + dp(ind+1, remCap - (td[ind]+ta[ind]));
	}
	int leave = dp(ind+1, remCap);
	//if(Math.max(take,leave)==take && take > 0)
	//    res.add(ind);    
	return memo[ind][remCap] = Math.max(take, leave);
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	String s = bf.nextLine();
	while(s != null){
	    StringTokenizer st = new StringTokenizer(s);
	    t = Integer.parseInt(st.nextToken());
	    w = Integer.parseInt(st.nextToken()); 
	    n = bf.nextInt();
	    if(n == 0){
		System.out.println("0\n0\n");
		s = bf.nextLine();
		s = bf.nextLine();
		continue;
	    }
	    depth = new int[n];
	    ta = new int[n];
	    td = new int[n];
	    quantity = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		depth[i] = bf.nextInt();
		ta[i] = w * depth[i];
		td[i] = 2 * w * depth[i];
		quantity[i] = bf.nextInt();
	    }

	    memo = new int[n][t+1];
	    res = new ArrayList<Integer>();
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    dp(0,t);
	    int r = memo[0][t];
	    int remT = t;
	    for (int i = 0; i < n-1; i++)
	    {
		
		    if(remT - (td[i]+ta[i]) >= 0 && memo[i+1][remT - (td[i]+ta[i])] == r - quantity[i]){
			res.add(i);
			remT -= (td[i]+ta[i]);
			r -= quantity[i];
		    }
	    }
	    if(remT - (td[n-1]+ta[n-1]) >= 0 && r - quantity[n-1] == 0)
		res.add(n-1);
	    int num = res.size();
	    System.out.println(memo[0][t]);
	    System.out.println(num);
	    for (int i = 0; i < num; i++)
	    {
		System.out.println(depth[res.get(i)] + " " + quantity[res.get(i)]);
	    }
	    System.out.println();
	    s = bf.nextLine();
	    s = bf.nextLine();
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
