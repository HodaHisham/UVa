package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ShoppingTrip11284 {

    private static final int INF = (int) 1e9;
    static int [][] adjMatrix, memo;
    static int[][] p;
    static Pair [] doub;
    static int V;
    static HashMap<Integer, Integer> map;
    static void floyd()
    {
	//adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise

	p = new int[V][V];		//to find the parent on the shortest path
	for(int i = 0; i < V; i++)
	    for(int j = 0; j < V; j++)
		p[i][j] = i;

	for(int k = 0; k < V; k++)
	    for(int i = 0; i < V; i++)
		for(int j = 0; j < V; j++)
		    if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
		    {
			adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
			p[i][j] = p[k][j];
		    }
    }
    public static int dp(int store, int mask){
	if(mask == (1<<doub.length)-1)
	    return -adjMatrix[store][0];
	if(memo[store][mask] != -1)
	    return memo[store][mask];
	int res = -adjMatrix[store][0];
	for (int i = 0; i < doub.length; i++)
	{
	    if(doub[i].to != store && adjMatrix[store][doub[i].to] < INF && (mask & (1<<map.get(doub[i].to)))==0){
		int tmp = doub[i].cost - adjMatrix[store][doub[i].to];
		res = Math.max(res, tmp + dp(doub[i].to, mask | (1<<map.get(doub[i].to))));
	    }
	}
	return memo[store][mask] = res;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	while(n-->0 ){
	    bf.nextLine();
	    V = bf.nextInt()+1;
	    int E = bf.nextInt();
	    adjMatrix = new int[V][V];
	    for (int i = 0; i < V; i++)
	    {
		for (int j = 0; j < V; j++)
		{
		    if(i == j)
			adjMatrix[i][j] = 0;
		    else
			adjMatrix[i][j] = INF;
		}
	    }

	    for (int i = 0; i < E; i++)
	    {
		int u = bf.nextInt();
		int v = bf.nextInt();
		int d = doubleToInt(bf.next());
		adjMatrix[u][v] = Math.min(d, adjMatrix[u][v]);
		adjMatrix[v][u] = Math.min(d, adjMatrix[v][u]);
	    }
	    int p = bf.nextInt();
	    map = new HashMap<Integer,Integer>();
	    doub = new Pair[p];
	    for (int i = 0; i < doub.length; i++)
	    {
		int store = bf.nextInt();
		int cost = doubleToInt(bf.next());
		doub[i] = new Pair(store,cost);
		map.put(store, i);
	    }

	    floyd();
	    memo = new int[V][1<<p];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    int res = dp(0,0);
	    if(res <= 0 )
		out.println("Don't leave the house");
	    else{
		out.printf("Daniel can save $%.2f\n" ,(double)Math.round(res)/100); 
	    }
	}
	out.flush();
	out.close();
    }
    /**
     * 2

4 5 
0 1 1.00
1 2 3.00
1 3 2.00
2 4 4.00
3 4 3.25
3
2 1.50
3 7.00
4 9.00

1 1
0 1 1.50
1
1 2.99
     **/

    static int doubleToInt(String x)
    {
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < x.length(); i++)
	    if(x.charAt(i)>='0'&&x.charAt(i)<='9')
		sb.append(x.charAt(i));
	return Integer.parseInt(sb.toString());
    }
    static class Pair implements Comparable<Pair>
    {
	int to,cost;
	Pair(int x, int y) {to = x; cost = y;}
	@Override
	public int compareTo(Pair o) {
	    // TODO Auto-generated method stub
	    return cost - o.cost;
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
