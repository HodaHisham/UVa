package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Conformity11286 {
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    int max = 0;
	    int res = 0;
	    for (int i = 0; i < n; i++)
	    {
		int [] a = new int[5];
		for (int j = 0; j < a.length; j++)
		{
		    a[j] = bf.nextInt();
		}
		Arrays.sort(a);
		String s = Arrays.toString(a);
		int val = map.get(s)==null?1:map.get(s)+1;
		map.put(s, val);
		if(val > max){
		    max = val;
		    res = val;
		}
		else if(val == max){
		    res+=val;
		}
	    }

	    out.println(res);
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
