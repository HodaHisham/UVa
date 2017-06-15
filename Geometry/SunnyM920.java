package GEOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SunnyM920 {
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-- > 0){
	    int n = bf.nextInt();
	    double ans = 0.0;
	    Pair[] p = new Pair[n];
	    for (int i = 0; i < n; i++)
	    {
		p[i] = new Pair(bf.nextInt(),bf.nextInt());
	    }
	    Arrays.sort(p);
	    int max = 0;
	    for (int i = p.length-2; i >= 0; i--)
	    {
		if(p[i].y > max){
		    double m = (double)(p[i].y-p[i+1].y)/(p[i].x-p[i+1].x);
		    double b = p[i].y-m*p[i].x;
		    double tmp = (max - b)/m;
		    ans += Math.hypot(p[i].x-tmp, p[i].y-max);
		    max = p[i].y;
		}
	    }
	    out.printf("%.2f\n", ans);
	}
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int x;
	int y;
	public Pair(int x, int y){
	    this.x = x;
	    this.y = y;
	}
	@Override
	public int compareTo(Pair o)
	{
	    // TODO Auto-generated method stub
	    return x - o.x;
	}

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
