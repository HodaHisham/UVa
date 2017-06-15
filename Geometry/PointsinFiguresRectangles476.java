package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PointsinFiguresRectangles476 {

    static class Rectangle {

	static final double EPS = 1e-9;

	Point ll, ur;

	Rectangle(Point a, Point b) { ll = a; ur = b; }

	double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

	boolean contains(Point p)
	{
	    return p.x + EPS < ur.x && p.x > ll.x + EPS && p.y + EPS < ur.y && p.y > ll.y + EPS;
	}

	Rectangle intersect(Rectangle r)
	{
	    Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
	    Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
	    if(Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
		return new Rectangle(ll, ur);
	    return null;
	}

    }
    static class Point{
	double x,y;
	public Point(double a, double b){
	    x = a; y = b;
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	Rectangle [] r = new Rectangle[10];
	int c = 0;
	while(true){
	    String s = bf.next();
	    if(s.startsWith("*"))
		break;
	    Point p = new Point(bf.nextDouble(), bf.nextDouble());
	    Point q = new Point(bf.nextDouble(), bf.nextDouble());
	    r[c++] = new Rectangle(new Point(p.x, q.y), new Point(q.x, p.y));
	}
	int q = 1; 
	while(true)
	{
	    String x = bf.next(), y = bf.next();
	    if(x.equals("9999.9") && y.equals("9999.9"))
		break;
	    Point p = new Point(Double.parseDouble(x), Double.parseDouble(y));
	    boolean flag = false;
	    for (int i = 0; i < c; i++)
	    {
		if(r[i].contains(p)){
		    out.println("Point "+ q +" is contained in figure "+(i+1));
		    flag = true;
		}
	    }
	    if(!flag) 
		out.println("Point "+ q +" is not contained in any figure");
	    q++;
	}
	out.flush();
	out.close();
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


	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}