package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Kolsberg1172 {
    static int nNor, nSth, valN [] , valS [];
    static Pair [][]memo;
    static HashMap<Integer, String> mNor,mSth;
    public static Pair dp(int n, int s){
	if(n == nNor || s == nSth)
	    return new Pair(0,0);
	if(memo[n][s] != null)
	    return memo[n][s];
	Pair l = new Pair(0,0);
	if(mNor.get(n).equals(mSth.get(s))){
	    Pair p = dp(n+1,s+1);
	    l = new Pair(p.max+valN[n]+valS[s],p.min+1);
	}
	Pair r = dp(n+1,s);
	Pair b = dp(n,s+1);
	return memo[n][s] = l.compareTo(r)> 0?l.compareTo(b)>0?l:b:r.compareTo(b)>0?r:b;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    nNor = bf.nextInt();
	    mNor = new HashMap<Integer,String>();
	    valN = new int[nNor];
	    for (int i = 0; i < nNor; i++)
	    {
		bf.next();
		mNor.put(i, bf.next());
		valN[i] = bf.nextInt();
	    }
	    nSth = bf.nextInt();
	    mSth = new HashMap<Integer,String>();
	    valS = new int[nSth];
	    for (int i = 0; i < nSth; i++)
	    {
		bf.next();
		mSth.put(i, bf.next());
		valS[i] = bf.nextInt();

	    }
	    memo = new Pair[nNor+1][nSth+1];
	    Pair ans = dp(0,0);
	    out.println(ans.max + " " + ans.min);
	}
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int max; int min;
	public Pair(int m1, int m2){
	    max = m1;
	    min = m2;
	}
	@Override
	public int compareTo(Pair o)
	{
	    if(max == o.max)
		return o.min - min;
	    return max - o.max;
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

	public boolean ready() throws IOException {return br.ready();}
    }

}
