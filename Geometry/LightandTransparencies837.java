package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LightandTransparencies837 {
   
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-- > 0){
	    int nl = bf.nextInt();
	    LineSegment[]  line = new LineSegment[nl*2];
	    for (int i = 0; i < nl; i++)
	    {
		Point p = new Point(bf.nextDouble(), bf.nextDouble());
		Point q = new Point(bf.nextDouble(), bf.nextDouble());
		double c = bf.nextDouble();
		line[i] = new LineSegment(p.compareTo(q)>0?q:p,false,c);
		line[nl+i] = new LineSegment(p.compareTo(q)>0?p:q,true,c);
	    }
	    Arrays.sort(line);
	    out.println(nl*2+1);
	    out.printf("-inf %.3f 1.000\n",line[0].p.x);
	    double t = 1;
	    double x = line[0].p.x;
	    for (int i = 0; i < nl*2; i++)
	    {
		if(x != line[i].p.x)
		    out.printf("%.3f %.3f %.3f\n", x,line[i].p.x,t);
		if(line[i].end)
		    t /= line[i].trans;
		else
		    t *= line[i].trans;
		x = line[i].p.x;
	    }
	    out.printf("%.3f +inf 1.000\n",line[line.length-1].p.x);
	    if(TC > 0)
		out.println();
	}
	out.flush();
	out.close();
    }
    static class Point implements Comparable<Point>{

	static final double EPS = 1e-9;

	double x, y;                  

	Point(double a, double b) { x = a; y = b; }  

	public int compareTo(Point p)
	{
	    if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
	    if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
	    return 0;
	}

	public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }

	static double sq(double x) { return x * x; }

    }
    static class LineSegment implements Comparable<LineSegment>{

	Point p; boolean end; double trans;

	LineSegment(Point a, boolean b, double t) { p = a; end = b; trans = t;}

	public int compareTo(LineSegment o)
	{
	    // TODO Auto-generated method stub
	    return p.x > o.p.x?1:-1;
	}

    }
    
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader r){	br = new BufferedReader(r);}


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
