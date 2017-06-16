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

public class WeightsandMeasures10154 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	ArrayList<Tur> tur = new ArrayList<Tur>();
	while(bf.ready()){
	    int w = bf.nextInt(), s = bf.nextInt();
	    if(s >= w)
		tur.add(new Tur(w,s));
	}
	Collections.sort(tur);
	int [] dp = new int[5608];
	Arrays.fill(dp, Integer.MAX_VALUE);
	dp[0] = 0;
	int max = 0;
	for (int i = 0; i < tur.size(); i++)
	{
	    Tur t = tur.get(i);
	    for(int j = max; j >= 0; j--){
		if(t.w + dp[j] <= t.s && t.w + dp[j] < dp[j+1]){
		    dp[j+1] = t.w + dp[j];
		    max = Math.max(max, j+1);
		}
	    }
	}
	out.println(max);
	out.flush();
	out.close();
    }
    static class Tur implements Comparable<Tur>{
	int w,s;
	public Tur(int a, int b){
	    w = a; s = b;
	}
	@Override
	public int compareTo(Tur o)
	{
	    // TODO Auto-generated method stub
	    if(s == o.s)
		return w - o.w;
	    return s - o.s;
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