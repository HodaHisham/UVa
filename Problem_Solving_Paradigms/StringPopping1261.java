package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class StringPopping1261 {
    static TreeMap<String, Boolean> memo;
    public static boolean dp(StringBuilder s){
	if(s.length() == 0)
	    return true;
	if(memo.get(s.toString()) != null)
	    return memo.get(s.toString());
	boolean ans = false;
	for (int i = 0; i < s.length(); i++)
	{
	    int j = i+1;
	    for (; j < s.length(); j++)
	    {
		if(s.charAt(i) != s.charAt(j))
		    break;
	    }
	    if(j > i+1){
		StringBuilder tmp = new StringBuilder(s.substring(0, i)).append(s.substring(j, s.length()));
		boolean b = dp(tmp);
		ans |= b;
		memo.put(tmp.toString(), b);
		i = j-1;
	    }
	}
	memo.put(s.toString(), ans);
	return ans;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	memo = new TreeMap<String, Boolean>();
	while(t-->0 ){
	    StringBuilder s = new StringBuilder(bf.nextLine());
	    out.println(dp(s)?1:0);
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
