package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Quadtrees297 {

    public static int[] ans(String a){
	int[] x = new int[1025];
	int level = 0;
	int [] four = new int[7];
	int nodes = 0;
	int num = 0;
	for (int i = 0; i < a.length(); i++)
	{
	    four[level]++;
	    if(a.charAt(i) == 'f')
	    {
		num = 1<<(2*(5-level));
		for (int j = 0; j < num; j++)
		{
		    x[nodes+j]++;
		}
		nodes += num;
		while(four[level] == 4){
		    four[level] = 0;
		    level--;
		}
	    }
	    else if(a.charAt(i) == 'e'){
		nodes += (1<<(2*(5-level)));
		while(four[level] == 4){
		    four[level] = 0;
		    level--;
		}
	    }
	    else if(a.charAt(i) == 'p'){
		level++;
	    }
	}
	return x;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	while(n-- > 0){
	    int [] x = ans(bf.nextLine());
	    int[] y = ans(bf.nextLine());
	    int[] res = new int[1025];
	    res[0] = (x[0]|y[0]);
	    for (int i = 1; i < res.length; i++)
	    {
		res[i] = res[i-1] + (x[i]|y[i]);
	    }
	     out.println("There are "+ (res[1024]) +" black pixels.");
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
