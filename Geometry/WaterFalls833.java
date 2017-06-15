package GEOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WaterFalls833 {
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-- > 0){
	    int np = bf.nextInt();
	    LS [] ln = new LS[np];
	    for (int i = 0; i < np; i++)
	    {
		int [] a = {bf.nextInt(),bf.nextInt(),bf.nextInt(),bf.nextInt()};
		int minX = Math.min(a[0],a[2]);
		int maxX = Math.max(a[0],a[2]);
		ln[i] = new LS(minX,minX==a[0]?a[1]:a[3],maxX,maxX==a[0]?a[1]:a[3]);
//		out.println(ln[i].x1 + " " + ln[i].y1 + " " + ln[i].x2 + " " + ln[i].y2);
	    }
	    int ns = bf.nextInt();
	    for (int i = 0; i < ns; i++)
	    {
		int x = bf.nextInt(), y = bf.nextInt();
		while(true){
		    int ind = -1;
		    double max = -1;
		    for (int j = 0; j < ln.length; j++)
		    {
			double tmp = ln[j].y1 + ((double)(ln[j].y2-ln[j].y1)*(x-ln[j].x1)/(ln[j].x2 - ln[j].x1));
			if(x >= ln[j].x1 && x <= ln[j].x2 && tmp < y && tmp > max){
			    max = tmp;
			    ind = j;
//			    out.println(x+ " " + y+ " " +j + " " + tmp);
			}
		    }
		    if(ind == -1)
			break;
		    y = Math.min(ln[ind].y1, ln[ind].y2);
		    x = y == ln[ind].y1?ln[ind].x1:ln[ind].x2;
		}
		out.println(x);
	    }

	    if(TC > 0)
		out.println();
	}
	out.flush();
	out.close();
    }
    static class LS{
	int x1; int x2; int y1; int y2;
	public LS(int x1, int y1, int x2, int y2){
	    this.x1 = x1;
	    this.x2 = x2;
	    this.y1 = y1;
	    this.y2 = y2;
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
