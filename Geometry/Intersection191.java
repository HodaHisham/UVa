package GEOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Intersection191 {
	public static void main(String[] args) throws IOException   {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = bf.nextInt();
		while(n-- > 0){
			Point x = new Point(bf.nextDouble(), bf.nextDouble()), y = new Point(bf.nextDouble(), bf.nextDouble());
			LineSegment l = new LineSegment(x, y);
			Point p = new Point(bf.nextDouble(),bf.nextDouble()); // ul
			Point q = new Point(bf.nextDouble(),bf.nextDouble()); //lr
			Point ul = new Point(Math.min(p.x,q.x),Math.max(p.y, q.y));
			Point lr = new Point(Math.max(p.x,q.x),Math.min(p.y, q.y));
			Point ll = new Point(Math.min(p.x,q.x),Math.min(p.y, q.y));
			Point ur = new Point(Math.max(p.x,q.x),Math.max(p.y, q.y));
			Rectangle r = new Rectangle(ll, ur);
			
			LineSegment one = new LineSegment(ur, ul);
			LineSegment two = new LineSegment(ul, ll);
			LineSegment three = new LineSegment(ll, lr);
			LineSegment four = new LineSegment(lr, ur);
			out.println((one.intersect(l))||(two.intersect(l))||(three.intersect(l))||(four.intersect(l))||(r.contains(x))||(r.contains(y))? "T":"F");
		}
		out.flush();
		out.close();
	}
	static class LineSegment {

		Point p, q;

		LineSegment(Point a, Point b) { p = a; q = b; }


		boolean intersect(LineSegment ls)
		{
			Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
			if(l1.parallel(l2))
			{
				if(l1.same(l2))
					return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
				return false;
			}
			Point c = l1.intersect(l2);
			return c.between(p, q) && c.between(ls.p, ls.q);
		}

	}
	static class Point{
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

		Point rotate(double angle)
		{
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Point(x * c - y * s, x * s + y * c);
		}
		// for integer points and rotation by 90 (counterclockwise) : swap x and y, negate x

		Point rotate(double theta, Point p)			//rotate around p
		{
			Vector v = new Vector(p, new Point(0, 0));
			return translate(v).rotate(theta).translate(v.reverse());
		}

		Point translate(Vector v) { return new Point(x + v.x , y + v.y); }

		Point reflectionPoint(Line l) 	//reflection point of p on line l
		{
			Point p = l.closestPoint(this);
			Vector v = new Vector(this, p);
			return this.translate(v).translate(v);
		}

		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}

		//returns true if it is on the line defined by a and b
		boolean onLine(Point a, Point b) 
		{
			if(a.compareTo(b) == 0) return compareTo(a) == 0;
			return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
		}

		boolean onSegment(Point a, Point b)
		{
			if(a.compareTo(b) == 0) return compareTo(a) == 0;
			return onRay(a, b) && onRay(b, a);
		}

		//returns true if it is on the ray whose start point is a and passes through b
		boolean onRay(Point a, Point b)
		{
			if(a.compareTo(b) == 0) return compareTo(a) == 0;
			return new Vector(a, b).normalize().equals(new Vector(a, this).normalize());
		}

		// returns true if it is on the left side of Line pq
		// add EPS to LHS if on-line points are accepted
		static boolean ccw(Point p, Point q, Point r)
		{
			return new Vector(p, q).cross(new Vector(p, r)) > 0;
		}

		static boolean collinear(Point p, Point q, Point r)
		{
			return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
		}

		static double angle(Point a, Point o, Point b)  // angle AOB
		{
			Vector oa = new Vector(o, a), ob = new Vector(o, b);
			return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
		}

		static double distToLine(Point p, Point a, Point b) //distance between point p and a line defined by points a, b (a != b)
		{
			if(a.compareTo(b) == 0) p.dist(a);
			// formula: c = a + u * ab
			Vector ap = new Vector(a, p), ab = new Vector(a, b);
			double u = ap.dot(ab) / ab.norm2();
			Point c = a.translate(ab.scale(u)); 
			return p.dist(c);
		}
		// Another way: find closest point and calculate the distance between it and p

		static double distToLineSegment(Point p, Point a, Point b) 
		{
			Vector ap = new Vector(a, p), ab = new Vector(a, b);
			double u = ap.dot(ab) / ab.norm2();
			if (u < 0.0) return p.dist(a);
			if (u > 1.0) return p.dist(b);        
			return distToLine(p, a, b); 
		}
		// Another way: find closest point and calculate the distance between it and p
	}
	static class Polygon{ 
		static final double EPS = 1e-9;

		Point[] g; 			//first point = last point, counter-clockwise representation

		Polygon(Point[] o) { g = o; }

		double perimeter()
		{
			double sum = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
				sum += g[i].dist(g[i+1]);
			return sum;
		}

		double area() 		//clockwise/anti-clockwise check, for convex/concave polygons
		{
			double area = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
				area += g[i].x * g[i+1].y - g[i].y * g[i+1].x;
			return Math.abs(area) / 2.0;			//negative value in case of clockwise
		}

		boolean isConvex()
		{
			if(g.length <= 3) // point or line
				return false;
			boolean ccw = Point.ccw(g[g.length - 2], g[0], g[1]);		//edit ccw check to accept collinear points
			for(int i = 1; i < g.length - 1; ++i)
				if(Point.ccw(g[i-1], g[i], g[i+1]) != ccw)
					return false;
			return true;
		}

		boolean inside(Point p)	//for convex/concave polygons - winding number algorithm 
		{
			double sum = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
			{
				double angle = Point.angle(g[i], p, g[i+1]);
				if((Math.abs(angle) < EPS || Math.abs(angle - Math.PI) < EPS) && p.between(g[i], g[i+1]))
					return true;
				if(Point.ccw(p, g[i], g[i+1]))
					sum += angle;
				else
					sum -= angle;
			}

			return Math.abs(2 * Math.PI - Math.abs(sum)) < EPS;		//abs makes it work for clockwise
		}
		/*
		 * Another way if the polygon is convex
		 * 1. Triangulate the polygon through p
		 * 2. Check if sum areas == polygon area
		 * 3. Handle empty polygon
		 */

		Polygon cutPolygon(Point a, Point b)	//returns the left part of the polygon, swap a & b for the right part
		{
			Point[] ans = new Point[g.length<<1];
			Line l = new Line(a, b);
			Vector v = new Vector(a, b);

			int size = 0;
			for(int i = 0; i < g.length; ++i)
			{
				double left1 = v.cross(new Vector(a, g[i]));
				double left2 = i == g.length - 1 ? 0 : v.cross(new Vector(a, g[i+1]));

				if(left1 + EPS > 0)	
					ans[size++] = g[i];
				if(left1 * left2 + EPS < 0)
					ans[size++] = l.intersect(new Line(g[i], g[i+1]));
			}

			if(size != 0 && ans[0] != ans[size-1])	//necessary in case g[0] is not in the new polygon
				ans[size++] = ans[0];
			return new Polygon(Arrays.copyOf(ans, size));
		}

		static Polygon convexHull(Point[] points)	//all points are unique, remove duplicates, edit ccw to accept collinear points
		{
			int n = points.length;
			Arrays.sort(points);
			Point[] ans = new Point[n<<1];
			int size = 0, start = 0;

			for(int i = 0; i < n; i++)
			{
				Point p = points[i];
				while(size - start >= 2 && !Point.ccw(ans[size-2], ans[size-1], p))	--size;
				ans[size++] = p;
			}
			start = --size;

			for(int i = n-1 ; i >= 0 ; i--)
			{
				Point p = points[i];
				while(size - start >= 2 && !Point.ccw(ans[size-2], ans[size-1], p))	--size;
				ans[size++] = p; 
			}
			//			if(size < 0) size = 0			for empty set of points
			return new Polygon(Arrays.copyOf(ans, size));			
		}

		Point centroid()		//center of mass
		{
			double cx = 0.0, cy = 0.0;
			for(int i = 0; i < g.length - 1; i++)
			{
				double x1 = g[i].x, y1 = g[i].y;
				double x2 = g[i+1].x, y2 = g[i+1].y;

				double f = x1 * y2 - x2 * y1;
				cx += (x1 + x2) * f;
				cy += (y1 + y2) * f;
			}
			double area = area();		//remove abs
			cx /= 6.0 * area;
			cy /= 6.0 * area;
			return new Point(cx, cy);
		}
	}

	static class Rectangle {

		static final double EPS = 1e-9;

		Point ll, ur;

		Rectangle(Point a, Point b) { ll = a; ur = b; }

		double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

		boolean contains(Point p)
		{
			return p.x + EPS < ur.x + EPS && p.x > ll.x + EPS  && p.y + EPS <= ur.y && p.y >= ll.y + EPS ;
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
	static class Line {

		static final double INF = 1e9, EPS = 1e-9;

		double a, b, c;

		Line(Point p, Point q)
		{
			if(Math.abs(p.x - q.x) < EPS) {	a = 1; b = 0; c = -p.x;	}
			else
			{
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}

		}

		Line(Point p, double m) { a = -m; b = 1; c =  -(a * p.x + p.y); } 

		boolean parallel(Line l) { return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }

		boolean same(Line l) { return parallel(l) && Math.abs(c - l.c) < EPS; }

		Point intersect(Line l)
		{
			if(parallel(l))
				return null;
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			if(Math.abs(b) < EPS)
				y = -l.a * x - l.c;
			else
				y = -a * x - c;

			return new Point(x, y);
		}

		Point closestPoint(Point p)
		{
			if(Math.abs(b) < EPS) return new Point(-c, p.y);
			if(Math.abs(a) < EPS) return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}

	}

	static class Vector {

		double x, y; 

		Vector(double a, double b) { x = a; y = b; }

		Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

		Vector scale(double s) { return new Vector(x * s, y * s); }              //s is a non-negative value

		double dot(Vector v) { return (x * v.x + y * v.y); }

		double cross(Vector v) { return x * v.y - y * v.x; }

		double norm2() { return x * x + y * y; }

		Vector reverse() { return new Vector(-x, -y); }

		Vector normalize() 
		{ 
			double d = Math.sqrt(norm2());
			return scale(1 / d);
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
