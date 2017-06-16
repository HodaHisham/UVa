package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SolveIt10341 {
    static final double EPS = (double)(1e-9);
    static int p,q,r,s,t,u;
    static double f(double x)
    {
	return p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * x * x + u;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    p = bf.nextInt();
	    q = bf.nextInt();
	    r = bf.nextInt();
	    s = bf.nextInt();
	    t = bf.nextInt();
	    u = bf.nextInt();
	    double lo = 0.0, hi = 1.0;
	    if(f(0)*f(1) > 0)
		out.println("No solution");
	    else{
		for(int i = 0; i < 100; i++)
		{
		    double mid = (lo + hi) / 2;
			if(f(0) * f(mid) <= 0)
				hi = mid;
			else
				lo = mid;
		}
		out.printf("%.4f\n", (lo+hi)/2);
	    }
	}
	out.flush();
	out.close();
    }

    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{
	    // TODO Auto-generated constructor stub
	    br = new BufferedReader(fileReader);
	}

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
