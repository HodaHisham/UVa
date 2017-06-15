package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Graveyard1388 {
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
            int n = bf.nextInt();
            int m = bf.nextInt();
            double l = 10000;
            double [] pos = new double[n];
            double [] newPos = new double[n+m];
            pos[0] = 0.0;
            newPos[0] = 0.0;
            for (int i = 1; i < pos.length; i++)
	    {
		pos[i] = pos[i-1] + l / n;
	    }
            for (int i = 1; i < newPos.length; i++)
            {
        	newPos[i] = newPos[i-1] + l / (n+m);
            }
            double res = 0.0;
            for (int i = 0, j = 0; i < pos.length; i++)
	    {
		int ind = j;
		while(j < newPos.length){
		    if(Math.abs(newPos[ind] - pos[i]) > Math.abs(newPos[j] - pos[i])){
			ind = j;
		    }
		    else if(newPos[j] > pos[i]){
			break;
		    }
		    j++;
		}
		res += Math.abs(newPos[ind] - pos[i]);
	    }
	    out.printf("%.4f\n", res);
	}
	out.flush();
	out.close();
    }
    //    static class Pair implements Comparable<Pair>{
    //	int x;
    //	int y;
    //	public Pair(int x, int y){
    //	    this.x = x;
    //	    this.y = y;
    //	}
    //	@Override
    //	public int compareTo(Pair o)
    //	{
    //	    // TODO Auto-generated method stub
    //	    return x - o.x;
    //	}
    //
    //    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{
	    br = new BufferedReader(fileReader);	
	}

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
