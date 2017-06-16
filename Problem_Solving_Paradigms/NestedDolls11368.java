
package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class NestedDolls11368 {
    static ArrayList<Integer> par;
    public static int bs(int h){
	int ans = -1, lo = 0, hi = par.size()-1;
	while(lo <= hi){
	    int mid = (lo+hi)>>1;
	if(par.get(mid) > h){
	    ans = mid;
	    hi = mid-1;
	}
	else lo = mid+1;
	}
	return ans;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    int m = bf.nextInt();
	    Pair[] dolls = new Pair[m];
	    for (int i = 0; i < m; i++)
	    {
		dolls[i] = new Pair(bf.nextInt(), bf.nextInt());
	    }
	    Arrays.sort(dolls);
	    par = new ArrayList<Integer>();
	    for (int i = 0; i < dolls.length; i++)
	    {
		int idx = bs(dolls[i].h);
		if(idx == -1)
		    par.add(dolls[i].h);
		else par.set(idx, dolls[i].h);
	    }
	    out.println(par.size());
	}
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int w; int h;
	public Pair(int w, int h){
	    this.w = w;
	    this.h = h;
	}
	public int compareTo(Pair o)
	{
	    if(w == o.w)
		return h - o.h;
	    return o.w - w;
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
