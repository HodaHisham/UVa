package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class GeniusMJ11894 { //Accepted c++
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int T = bf.nextInt();
	while(T-- > 0){
	    int n = bf.nextInt();
	    Point [][] p = new Point[4][n];
	    for (int i = 0; i < n; i++)
	    {
		int x = bf.nextInt();
		int y = bf.nextInt();
		p[0][i] = new Point(x,y);
		p[1][i] = new Point(-y,x);
		p[2][i] = new Point(y,-x);
	    }
	    for (int i = 0; i < 3; i++)
	    {
		Arrays.sort(p[i]);
	    }
	    for (int i = 0; i < p.length; i++)
	    {
		p[3][i] = new Point(-p[0][n-1-i].x,-p[0][n-1-i].y);
	    }
	    boolean flag [] = new boolean[4];
	    Arrays.fill(flag, true);
	    Point q [] = new Point[n];
	    for (int i = 0; i < n; i++)
	    {
		q[i] = new Point(bf.nextInt(), bf.nextInt());
	    }
	    Arrays.sort(q);
	    int [] [] diff = new int[4][2];
	    for (int i = 0; i < diff.length; i++)
	    {
		diff[i][0] = p[i][0].x - q[0].x;
		diff[i][1] = p[i][0].y - q[0].y;
//		out.println(Arrays.toString(p[i]));

	    }
	    for (int j = 0; j < 4; j++)
	    {
		for (int i = 1; i < q.length; i++)
		{
		    int dx = p[j][i].x - q[i].x;
		    int dy = p[j][i].y - q[i].y;
		    if(!(dx == diff[j][0] && dy == diff[j][1])){
//			out.println(i+ " " + j);
			flag[j] = false;
			break;
		    }
		}
		if(!flag[0]&&!flag[1]&&!flag[2]&&!flag[3])
		    break;
	    }
//	    out.println(Arrays.toString(q));
	    //	    	    out.println(Arrays.toString(vec)); 

	    out.println(flag[0]||flag[1]||flag[2]||flag[3]?"MATCHED":"NOT MATCHED");
	}
	out.flush();
	out.close();
    }
    static class Point implements Comparable<Point>{

	static final double EPS = 1e-9;

	int x, y;                  

	Point(int a, int b) { x = a; y = b; }  

	public int compareTo(Point p)
	{
	    if(x != p.x) return x > p.x ? 1 : -1;
	    if(y != p.y) return y > p.y ? 1 : -1;
	    return 0;
	}

//	Point translate(Vector v) { return new Point(x + v.x , y + v.y); }

	public String toString(){
	    return "("+x + "," + y+")";
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
