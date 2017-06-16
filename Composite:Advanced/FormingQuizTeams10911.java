package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FormingQuizTeams10911 {
    static int n;
    static int INF = (int)1e9;
    static TreeMap<Integer, Pair>points;
    static double[][] memo;
    public static double dp(int ind, int mask){
	if(ind == 2*n || mask == (1<<2*n)-1)
	    return 0;
	if(memo[ind][mask]!=-1)
	    return memo[ind][mask];
	double dist = INF;
	for (int i = ind+1; i < 2*n; i++)
	{
	    if((mask & (1<<i)) == 0){
		double var = Math.sqrt((points.get(i).x - points.get(ind).x)* (points.get(i).x - points.get(ind).x)+(points.get(i).y - points.get(ind).y)* (points.get(i).y - points.get(ind).y)) ;
		//System.out.println(dist + " " + var  + " " + i);
		int m = mask|(1<<ind);
		m |= (1<<i);
		int j = ind;
		for ( j = ind+1; j < 2*n && (m & (1<<j)) != 0 ; j++);
		//System.out.println(j+ " " + i);
		dist = Math.min(dist, var + dp(j,m));
	    }
	}
	return memo[ind][mask] = dist;
    }
    /** 
5
sohel 10 10
mahmud 20 10
sanny 5 5
prince 1 1
per 120 3
mf 6 6
kugel 50 60
joey 3 24
limon 6 9
manzoor 0 0
1
derek 9 9
jimmy 10 10
0
     **/
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int count = 1;
	while(true){
	    n = bf.nextInt();
	    if(n == 0)
		break;
	    memo = new double[2*n][1<<(2*n)];
	    points = new TreeMap<Integer,Pair>();
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    for (int i = 0; i < 2*n; i++)
	    {
		bf.next();
		points.put(i, new Pair(bf.nextInt(),bf.nextInt()));

	    }
	    dp(0,0);
	    out.printf("Case %d: %.2f\n",(count++),memo[0][0]);
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int x;
	int y;
	public Pair(int x, int y){
	    this.x = x;
	    this.y = y;
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

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
	}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}


    }
}
