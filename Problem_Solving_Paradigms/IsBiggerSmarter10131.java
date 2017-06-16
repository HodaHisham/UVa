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
import java.util.StringTokenizer;

public class IsBiggerSmarter10131 {
    static ArrayList<Integer> res;
    static int memo[][],n;
    static ArrayList<Elephant> inp;
    public static int dp(int ind, int prev){
	if(ind == n)
	    return 0;
	if(memo[ind][prev] != -1)
	    return memo[ind][prev];
	int ans = dp(ind+1,prev);
	if(inp.get(ind).w > inp.get(prev).w && inp.get(ind).iq < inp.get(prev).iq)	
	    ans = Math.max(ans, 1+dp(ind+1,ind));
	return memo[ind][prev] = ans;
    }
    public static void print(int ind, int prev){
	if(ind == n)
	    return;
	int opt = dp(ind,prev);
	int ans = dp(ind+1,prev);
	if(opt == ans){
	    print(ind+1,prev);
	}
	else {
	    res.add(inp.get(ind).ind);
	    print(ind+1,ind);
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	inp = new ArrayList<Elephant>();
	inp.add(new Elephant(-1, 10001,0));
	int cases = 1;
	while(bf.ready()){
	    inp.add(new Elephant(bf.nextInt(), bf.nextInt(),cases++));
	}
	n = inp.size();
	memo = new int[n+1][n+1];
	for (int i = 0; i < memo.length; i++)
	{
	    Arrays.fill(memo[i], -1);
	}
	Collections.sort(inp);
//	out.println(inp.toString());
	out.println(dp(1,0));
	res = new ArrayList<Integer>();
	print(1,0);
	for (int i = 0; i < res.size(); i++)
	    out.println(res.get(i));
	out.flush();
	out.close();
    }
    static class Elephant implements Comparable<Elephant>{
	int w; int iq; int ind;
	public Elephant(int weight, int IQ, int i){
	    w = weight;
	    iq = IQ;
	    ind = i;
	}
	@Override
	public int compareTo(Elephant o)
	{
	    return o.iq - iq;
	}
	public String toString(){
	    return w + " " + iq + " " + ind;
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
