package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Railway10263 {

    static final double EPS = 1e-9;

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	StringBuilder sb = new StringBuilder();
	while(bf.ready()){
	    Point m = new Point(bf.nextDouble(), bf.nextDouble());
	    Point a = new Point(0, 0), b = new Point(0, 0), c = new Point(0, 0);
	    int n = bf.nextInt();
	    double min = Double.MAX_VALUE;
	    a = new Point(bf.nextDouble(), bf.nextDouble());
	    for (int i = 0; i < n; i++)
	    {
		b = new Point(bf.nextDouble(), bf.nextDouble());
		Point tmp = new Line(a, b).closestPoint(m);
		if(!tmp.between(a, b))
		{
		    if(a.dist(tmp) < b.dist(tmp))
			tmp = a;
		    else tmp = b;
		}
		double dist = tmp.dist(m);
		if(min > dist + EPS){
		    min = dist;
		    c = tmp;
		}
		a = b;
	    }
	    sb.append(String.format("%.4f\n%.4f\n", c.x, c.y));
	}
	out.print(sb);
	out.flush();
	out.close();
    }

    static class Point implements Comparable<Point> {

	double x, y;

	Point(double a, double b)
	{
	    x = a;
	    y = b;
	}
	public String toString(){
	    return x + " " + y;
	}
	public int compareTo(Point p)
	{
	    if (Math.abs(x - p.x) > EPS)
		return x > p.x ? 1 : -1;
		if (Math.abs(y - p.y) > EPS)
		    return y > p.y ? 1 : -1;
		    return 0;
	}

	public double dist(Point p)
	{
	    return Math.sqrt(sq(x - p.x) + sq(y - p.y));
	}

	static double sq(double x)
	{
	    return x * x;
	}

	Point translate(Vector v)
	{
	    return new Point(x + v.x, y + v.y);
	}

	boolean between(Point p, Point q)
	{
	    return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
		    && y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
	}
	static double distToLineSegment(Point p, Point a, Point b)
	{
	    Vector ap = new Vector(a, p), ab = new Vector(a, b);
	    double u = ap.dot(ab) / ab.norm2();
	    if (u < 0.0)
		return p.dist(a);
	    if (u > 1.0)
		return p.dist(b);
	    return distToLine(p, a, b);
	}

	static double distToLine(Point p, Point a, Point b)
	{
	    if (a.compareTo(b) == 0)
		p.dist(a);
	    // formula: c = a + u * ab
	    Vector ap = new Vector(a, p), ab = new Vector(a, b);
	    double u = ap.dot(ab) / ab.norm2();
	    Point c = a.translate(ab.scale(u));
	    return p.dist(c);
	}
    }

    static class Vector {

	double x, y;

	Vector(double a, double b)
	{
	    x = a;
	    y = b;
	}

	Vector(Point a, Point b)
	{
	    this(b.x - a.x, b.y - a.y);
	}

	Vector scale(double s)
	{
	    return new Vector(x * s, y * s);
	}

	double dot(Vector v)
	{
	    return (x * v.x + y * v.y);
	}

	double cross(Vector v)
	{
	    return x * v.y - y * v.x;
	}

	double norm2()
	{
	    return x * x + y * y;
	}

	Vector reverse()
	{
	    return new Vector(-x, -y);
	}

	Vector normalize()
	{
	    double d = Math.sqrt(norm2());
	    return scale(1 / d);
	}

	boolean equals(Vector v)
	{
	    return (x - v.x) < EPS && (y - v.y) < EPS;
	}
    }

    static class Line {

	static final double INF = 1e9, EPS = 1e-9;

	double a, b, c;

	Line(Point p, Point q)
	{
	    if (Math.abs(p.x - q.x) < EPS)
	    {
		a = 1;
		b = 0;
		c = -p.x;
	    } else
	    {
		a = (p.y - q.y) / (q.x - p.x);
		b = 1.0;
		c = -(a * p.x + p.y);
	    }
	}

	Line(Point p, double m)
	{
	    a = -m;
	    b = 1;
	    c = -(a * p.x + p.y);
	}

	boolean parallel(Line l)
	{
	    return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
	}

	Point intersect(Line l)
	{
	    if (parallel(l))
		return null;
	    double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
	    double y;
	    if (Math.abs(b) < EPS)
		y = -l.a * x - l.c;
	    else
		y = -a * x - c;

	    return new Point(x == 0?0:x, y == 0?0:y);
	}

	Point closestPoint(Point p)
	{
	    if (Math.abs(b) < EPS)
		return new Point(-c, p.y);
	    if (Math.abs(a) < EPS)
		return new Point(p.x, -c);
	    return intersect(new Line(p, 1 / a));
	}
    }

    static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s)
	{
	    br = new BufferedReader(new InputStreamReader(s));
	}

	public Scanner(FileReader fileReader)
	{
	    br = new BufferedReader(fileReader);
	}

	public String next() throws IOException
	{
	    while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}

	public String nextLine() throws IOException
	{
	    return br.readLine();
	}

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if (x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for (int i = start; i < x.length(); i++)
		if (x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		} else
		{
		    sb.append(x.charAt(i));
		    if (dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}