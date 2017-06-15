package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OverlappingRectangles460 {
    static  class Rectangle {

	static final int EPS = 0;

	Point ll, ur;

	Rectangle(Point a, Point b) { ll = a; ur = b; }

	double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

	boolean contains(Point p)
	{
	    return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
	}

	Rectangle intersect(Rectangle r)
	{
	    Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
	    Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
	    if(Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
		return new Rectangle(ll, ur);
	    return null;
	}
	public String toString(){
	    return ll + " " + ur;
	}

    }
    static class Point{
	int x,y;
	public Point(int a, int b){
	    x = a; y = b;
	}
	public String toString(){
	    return x + " " + y;
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    Rectangle r1 = new Rectangle(new Point(bf.nextInt(), bf.nextInt()), new Point(bf.nextInt(), bf.nextInt()));
	    Rectangle r2 = new Rectangle(new Point(bf.nextInt(), bf.nextInt()), new Point(bf.nextInt(), bf.nextInt()));
	    Rectangle res = r1.intersect(r2);
	    if(res == null) out.println("No Overlap");
	    else out.println(res);
	    if(TC != 0)
		out.println();
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

	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}