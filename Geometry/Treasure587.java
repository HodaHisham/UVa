package GEOM;
import java.io.*;
import java.util.*;
public class Treasure587{
    static final double c = Math.sqrt(2)/2;
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
        int TC = 1;
        HashMap<String, Pair> map = new HashMap<String, Pair>();
        map.put("N", new Pair(0, 1));
        map.put("S", new Pair(0, -1));
        map.put("E", new Pair(1, 0));
        map.put("W", new Pair(-1, 0));
        map.put("NE", new Pair(c, c));
        map.put("SE", new Pair(c, -c));
        map.put("SW", new Pair(-c, -c));
        map.put("NW", new Pair(-c, c));
        while(true){
	    String inp = bf.nextLine();
	    if(inp.equals("END")){
		break;
	    }
	    StringTokenizer text = new StringTokenizer(inp.substring(0, inp.length()-1),",");
	    String st = text.nextToken();
	    double x = 0, y = 0, d = 0;
	   while(true){
		int i = 0;
                for (;i < st.length(); ++i)
		{
		    if(st.charAt(i) >= 'A' && st.charAt(i) <= 'Z')
			break;
		}
                x += map.get(st.substring(i)).dx * Integer.parseInt(st.substring(0, i));
                y += map.get(st.substring(i)).dy * Integer.parseInt(st.substring(0, i));
                if(!text.hasMoreTokens())
                    break;
                st = text.nextToken();
	    } 
	    d = Math.hypot(x, y);
	    out.printf("Map #%d\n", TC++);
	    out.printf("The treasure is located at (%.3f,%.3f).\nThe distance to the treasure is %.3f.\n\n",x,y,d);
	    
	}
	out.flush();
	out.close();

    }
    static class Pair{
	double dx;
	double dy;
	public Pair(double x, double y){
	    dx = x;
	    dy = y;
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