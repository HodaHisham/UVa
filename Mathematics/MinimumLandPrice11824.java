package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class MinimumLandPrice11824 {
    static int max = 5000000;
    static long pow(int a, int e)	// O(log e)
    {
	long res = 1;
	while(e > 0)
	{
	    if((e & 1) == 1)
		res *= a;
	    if(res > max)
		return -1;
	    a *= a;
	    e >>= 1;
	}
	return res;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int tc = bf.nextInt();
	 
	while(tc-->0){
	    ArrayList<Integer> cost = new ArrayList<Integer>();
	    while(true){
		int t = bf.nextInt();
		if(t == 0)
		    break;
		cost.add(t);
	    }
	    Collections.sort(cost);
	    long ans = 0L; 
	    boolean flag = true;
	    for (int i = 0, j = cost.size(); i < cost.size(); i++,j--)
	    {
		long tmp = pow(cost.get(i),j);
		if(tmp == -1)
		{
		    flag = false;
		    break;
		}
		ans += tmp;
		if(ans>max)
		{
		    flag = false;
		    break;
		}
	    }
	    out.println(flag && 2*ans < max?2*ans:"Too expensive");
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
