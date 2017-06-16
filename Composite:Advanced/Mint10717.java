package Misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Mint10717 {
 
    public static int gcd(int a, int b){
	return b == 0? a:gcd(b,a%b);
    }
    public static int lcm(int a, int b){
	return a * (b / gcd(a,b));
    }

    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    int t = bf.nextInt();
	    if(n == 0 && t == 0)
		break;
	    int [] val = new int[n];
	    for(int i = 0; i < n; i++){
		val[i] = bf.nextInt();
	    }
	    TreeSet<Integer> lcm = new TreeSet<Integer>();
	    for (int i = 0; i < val.length; i++)
	    {
		for (int j = i+1; j < val.length; j++)
		{
		    for (int k = j+1; k < val.length; k++)
		    {
			for (int l = k+1; l < val.length; l++)
			{
			    lcm.add(lcm(val[i],lcm(val[j],lcm(val[k],val[l]))));
			}
		    }
		}
	    }
//            out.println(lcm.toString());
	    for (int i = 0; i < t; i++)
	    {
		int q = bf.nextInt();
		Integer size = lcm.ceiling(q);
		int min = size == null?lcm.last()*((int)Math.ceil(q/lcm.last())+1):size, max = 0;
		if(size == null)
		    size = lcm.last()+1;
		for (Integer num : lcm)
		{
		    int d = q/num;
		    max = Math.max(max, num*d);
                    d = (int)Math.ceil((double)q/num);
		    if(num*d >= q)
			min = Math.min(min, num*d);
//		    out.println(d + " " + num);
		    if(num == size)
			break;
		}
		out.println(max + " " + min);
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
