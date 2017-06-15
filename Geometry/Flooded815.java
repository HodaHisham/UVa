package GEOM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Flooded815 {
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    int m = bf.nextInt();
	    int n = bf.nextInt();
	    if(n == 0 && m == 0)
		break;
	    TreeMap<Integer, Integer> elv = new TreeMap<Integer,Integer>();
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i < m; i++)
	    {
		for (int j = 0; j < n; j++)
		{
		    int val = bf.nextInt();
		    Integer num = elv.get(val);
		    elv.put(val,num==null?1:num+1);
		    min = Math.min(min, val);
		}
	    }
	    int vol = bf.nextInt();
	    double hei = min;
	    int num = 0;
	    while(vol > 0){
		int key = (int) hei;
		int val = 0;
		if(!elv.isEmpty()){
		    key = elv.firstKey();
		    val = elv.remove(key);
		}
		int tmp = (num+val)*100*((elv.isEmpty()?(int)hei:elv.firstKey())-(int)hei);
		if(tmp > 0 && vol >= tmp && val > 0){
		    vol -= tmp;
		    num += val;
		    hei = elv.isEmpty()?(int)hei:elv.firstKey();
		}
		else{
		    hei+= (double)vol/(100*(num+val));
		    num += val;
		    vol = 0;
		}
	    }
	    out.printf("Region %d\nWater level is %.2f meters.\n%.2f percent of the region is under water.\n\n",cases++,hei,100.0*num/n/m);
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
