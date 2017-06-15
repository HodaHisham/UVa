package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CrossedLadders10566 {
    static final double EPS = 1e-9;
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready())
	{
            double x = bf.nextDouble();
            double y = bf.nextDouble();
            double c = bf.nextDouble();
            double lo = 0, hi = Math.min(x, y);
            while(Math.abs(hi-lo)>EPS){
        	double ans = (lo + hi)/2;
        	double s = Math.sqrt(y*y-ans*ans);
        	double t = Math.sqrt(x*x-ans*ans);
        	if(s*t/(s+t) <= c){
        	    hi = ans;
        	}
        	else
        	    lo = ans;
        	    
            }
            out.printf("%.3f\n",hi);
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
	{    br = new BufferedReader(fileReader);	}

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
