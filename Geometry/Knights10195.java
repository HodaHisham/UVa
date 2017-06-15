package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Knights10195 {
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    double a = bf.nextDouble();
	    double b = bf.nextDouble();
	    double c = bf.nextDouble();
	    double[]p = {a,b,c};
	    Arrays.sort(p);
	    if(a+b <= c){
		out.printf("The radius of the round table is: %.3f\n",0.0);
                
	    }
	    else{
		double s = 0.5*(a+b+c);
		double res = Math.sqrt(s*(s-a)*(s-b)*(s-c))/s;
		out.printf("The radius of the round table is: %.3f\n",res);
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
