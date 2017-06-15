package GEOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cranes11515 {
    static int c,memo[][];
    static Circle[]cir;
    public static int dp(int ind, int mask){
	if(ind == c)
	{
	    int tmp = 0;
	    for (int i = 0; i < c; i++)
	    {
		if((mask & (1<<i)) != 0)
		    tmp += cir[i].area();
	    }
	    return tmp;
	}
	if(memo[ind][mask] != -1)
	    return memo[ind][mask];
	int take = 0;
	boolean flag = true;
	for (int i = 0; i < ind; i++)
	{
	    if((mask & (1<<i)) != 0 && cir[ind].intersect(cir[i])){
		flag = false;
		break;
	    }
	}
	if(flag)
	    take = dp(ind+1,mask|(1<<ind));
	int leave = dp(ind+1,mask);
	return memo[ind][mask] = Math.max(take, leave);
    }
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-- > 0)
	{
	    c = bf.nextInt();
	    cir = new Circle[c];
	    for (int i = 0; i < c; i++)
	    {
		cir[i] = new Circle(new Point(bf.nextInt(), bf.nextInt()), bf.nextInt());
	    }
	    memo = new int[c][(1<<c)];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    out.println(dp(0,0));
	}
	out.flush();
	out.close();
    }
    static class Circle { 	//equation: (x-c.x)^2 + (y-c.y)^2 = r^2

	static final double EPS = 1e-9;

	Point c;
	int r;

	Circle(Point p, int k) { c = p; r = k; }

	int area() { return r*r; }

	boolean intersect(Circle cir)
	{
	    return c.dist(cir.c) <= r + cir.r + EPS ;
//	    && c.dist(cir.c) + EPS >= Math.abs(r - cir.r)
	}
    }

    static class Point implements Comparable<Point>{

	static final double EPS = 1e-9;

	int x, y;                  

	Point(int a, int b) { x = a; y = b; }  

	public int compareTo(Point p)
	{
	    if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
	    if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
	    return 0;
	}

	public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }

	static double sq(double x) { return x * x; }

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
