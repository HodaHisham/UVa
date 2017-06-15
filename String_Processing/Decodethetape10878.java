package Strings;

import java.io.*;
import java.util.*;
public class Decodethetape10878 {

    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	bf.nextLine();
	String s;
	while(!(s = bf.nextLine()).equals("___________")){
	    int num = 0;
	    int base = 1;
             for (int i = 9; i > 6; i--)
	    {
		num += s.charAt(i)=='o'?(base):0;
		base<<=1;
	    }
             for (int i = 5; i > 1; i--)
	    {
        	 num += s.charAt(i)=='o'?(base):0;
 		base<<=1;
	    }
             out.print((char)num);
	}
	out.flush();
	out.close();
    }
    /** static class newType implements Comparable{
    	int a;
    	int b;
    	public newType(int a,int b){
    	    this.a = a;
    	    this.b = b;

    	}
    	public int compareTo(newType t){
    	    if(a != t.a)
    		return a - t.a;
    	    return b - t.b;

    	}
        }**/
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
