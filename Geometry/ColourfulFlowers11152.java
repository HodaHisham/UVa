package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ColourfulFlowers11152 {
    
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int a = bf.nextInt();
	    int b = bf.nextInt();
	    int c = bf.nextInt();
	    double s = 0.5*(a + b + c);
	    double res2 = Math.sqrt(s*(s-a)*(s-b)*(s-c)); // 1 big circle 2 tri 3 small
	    double res3 = Math.PI*(res2/s)*(res2/s);
	    double res1 = Math.PI*((a*b*c)/ (4.0*res2))*((a*b*c)/ (4.0*res2));
	    out.printf("%.4f %.4f %.4f\n", Math.round((res1-res2)*10000)/10000.0, Math.round((res2-res3)*10000)/10000.0, Math.round(res3*10000)/10000.0);
	}
	out.flush();
	out.close();
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
	public Scanner(FileReader s){	br = new BufferedReader(s);}

	
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
