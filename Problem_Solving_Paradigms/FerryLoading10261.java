package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FerryLoading10261 {
    static int len, memo[][];
    static ArrayList<Integer> cars;
    public static int dp(int ind, int remL){
	if(ind+1 == cars.size())
	    return ind;
	int remR = cars.get(ind)-remL;
	if(remR == len && remL == len)
	    return ind;
	if(memo[ind][remL] != -1)
	    return memo[ind][remL];
	int size = cars.get(ind+1)-cars.get(ind);
	int l = 0;
	if(remL + size <= len)
	    l = dp(ind+1,remL + size);
	int r = 0;
	if(remR + size <= len)
	    r = dp(ind+1,remL);
	return memo[ind][remL] = Math.max(l, Math.max(r, ind));
    }
    static ArrayList<String> ans;
    public static void printDp(int ind, int remL){
	if(ind+1 == cars.size())
	    return;
	int remR = cars.get(ind)-remL;
	if(remR == len && remL == len)
	    return;
	int opt = dp(ind, remL);
	int size = cars.get(ind+1)-cars.get(ind);
	int l = 0;
	if(remL + size <= len)
	    l = dp(ind+1,remL + size);
	int r = 0;
	if(remR + size <= len)
	    r = dp(ind+1,remL);
	if(opt == ind){
	    return;
	}
	if(opt == l){
	    ans.add("port");
	    printDp(ind+1, remL + size);
	    return;
	}
	else if(opt == r){
	    ans.add("starboard");
	    printDp(ind+1,remL);
	    return;
	}
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	while(n-->0){
	    len = bf.nextInt()*100;
	    cars = new ArrayList<Integer>();
	    cars.add(0);
	    while(true){
		int l = bf.nextInt();
		if(l == 0)
		    break;
		cars.add(cars.get(cars.size()-1)+l);
	    }
	    memo = new int[cars.size()][len+1];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    out.println(dp(0,0));
	    ans = new ArrayList<String>();
	    printDp(0, 0);
	    for (int i = 0; i < ans.size(); i++)
	    {
		out.println(ans.get(i));
	    }
	    if(n>0)
		out.println();
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
