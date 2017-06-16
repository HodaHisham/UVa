package Misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SettingProblems11269 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	StringBuilder sb = new StringBuilder();
	while(bf.ready())
	{
	    int n = bf.nextInt();
	    Pair [] g = new Pair[n];
	    for (int i = 0; i < g.length; i++)
	    {
		g[i] = new Pair(bf.nextInt(), 0);
	    }
	    int sum = 0;
	    for (int i = 0; i < g.length; i++)
	    {
		g[i].m = bf.nextInt();
		sum += g[i].m;
	    }
	    Arrays.sort(g);
	    int ans = sum, timeN = g[0].n, timeM = 0;
	    for (int i = 0; i < g.length; i++)
	    {
		if(timeM < timeN){
		    ans += timeN-timeM;
		    timeM += timeN-timeM;
		}
		timeM += g[i].m;
		timeN += i+1 < n?g[i+1].n:0;
	    }
	    sb.append(ans).append("\n");
	}
	out.print(sb);
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int n,m;
	public Pair(int a, int b){
	    n  = a;
	    m = b;
	}
	@Override
	public int compareTo(Pair o)
	{
	    // fir: this then o
	    int fir = n+Math.max(o.n, m) + o.m, sec = o.n+Math.max(n, o.m)+m;
	    return fir > sec?1:fir < sec?-1:0;
	}
	public String toString(){
	    return  n + " " + m;
	}
    }
    static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s)
	{
	    br = new BufferedReader(new InputStreamReader(s));
	}

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

	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}

	public String nextLine() throws IOException
	{
	    return br.readLine();
	}

	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}