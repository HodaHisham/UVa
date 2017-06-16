package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KnightWar11906 {
    static int m,n,r,c,odd,even;
    static int[][]grid;
    //static int [] dx ,dy;
    static int [] nav;
    static boolean[][] vis;
    public static boolean isValid(int x , int y){
	return x >= 0 && y >= 0 && x < r && y < c && grid[x][y] != -1 ;
    }
    public static void dfs(int i, int j, int[] dx,int[] dy,boolean start){

	int k = 0;
	if(i == 0 && j== 0 && !start) return;
	for (int j2 = 0; j2 < nav.length; j2++)
	{
	    int x = i+dx[nav[j2]], y = j+dy[nav[j2]];
	    if(isValid(x, y)){
		//System.out.println(x+" "+y);
		if(!vis[x][y]){
		    vis[x][y] = true;
		    dfs(x,y, dx,dy,false);
		}
		k++;
	    }
	}
	if((k&1)!= 0)
	    odd++;
	else even++;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	for (int cases = 1; cases <= t; cases++)
	{

	    r = bf.nextInt(); 
	    c = bf.nextInt();
	    m = bf.nextInt();
	    n = bf.nextInt();
	    int w = bf.nextInt();
	    grid = new int[r][c];
	    vis = new boolean[r][c];
	    even = 0;
	    odd = 0;
	    for (int i = 0; i < w; i++)
	    {
		int x = bf.nextInt();
		int y = bf.nextInt();
		grid[x][y] = -1;
	    }
	    int [] dx ={m,m,-m,-m,n,n,-n,-n};
	    int [] dy = {n,-n,n,-n,m,-m,m,-m};
	    if(m==0 && n==0){
		odd = 1;
		out.println("Case " + cases + ": " + even + " "+ odd);
		continue;
	    }

	    else if(m==n) {nav = new int[4]; nav[0] = 0; nav[1]= 1; nav[2] = 2; nav[3]= 3;}
	    else if(m==0){ nav = new int[4]; nav[0] = 0; nav[1]= 1; nav[2] = 5; nav[3]= 6;}
	    else if(n==0) {nav = new int[4]; nav[0] = 1; nav[1]= 2; nav[2] = 4; nav[3]= 5;}
	    else {nav = new int[8]; nav[0] = 0; nav[1]= 1; nav[2] = 2; nav[3]= 3; nav[4] = 4; nav[5]= 5; nav[6] = 6; nav[7]= 7;}
	    int k = 0;
	    vis[0][0] = true;
	    for (int j2 = 0; j2 < nav.length; j2++)
	    {
		int x = dx[nav[j2]], y = dy[nav[j2]];
		//System.out.println( x + " "+ y+"\n");
		if(isValid(x, y)){
		    if(!vis[x][y]){
			vis[x][y] = true;
			dfs(x,y, dx,dy,true);
		    }
		    k++;
		}
	    }
	    /**
	     * 2
3 3 2 1
0
4 4 1 2
2
3 3
1 1
	     */
	    if(k%2 == 0)
		even++;
	    else odd++;


	    out.println("Case " + cases + ": " + even + " "+ odd);
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
