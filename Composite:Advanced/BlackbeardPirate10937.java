package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BlackbeardPirate10937 {

    static int w,h;
    static char[][]grid;
    static int[][]dist;
    static int [] dx = {1,0,-1,0,1,1,-1,-1};
    static int [] dy = {0,1,0,-1,1,-1,1,-1};
    static HashMap<Integer, Integer>map;
    static int INF = (int)1e9;
    static int s,V;
    static int [][] memo;
    public static boolean isValid(int x , int y){
	return x >= 0 && y >= 0 && x < h && y < w;
    }
    static class Pair{
	int x; int y; int n;
	public Pair(int a, int b, int w){
	    x = a; y = b; n = w;
	}
    }
    public static int dp(int mask, int ind){
	if(mask == (1<<(V-1))-1)
	    return dist[ind][0];
	if(memo[mask][ind] != -1)
	    return memo[mask][ind];
	int ans = INF;
	for (int i = 1; i < dist.length; i++)
	{
	    if(ind != i && (mask & (1<<(i-1))) == 0 && dist[ind][i] != INF){
		int tmp = dp(mask|(1<<(i-1)),i);
		if(tmp < INF)
		    ans = Math.min(ans, (dist[ind][i]+tmp));
	    }
	}
	return memo[mask][ind] = ans;
    }

    static void bfs(int x, int y)
    {
	Queue<Pair> q = new LinkedList<Pair>();
	q.add(new Pair(x, y,0));
	grid[x][y] = '~';
	while(!q.isEmpty())
	{
	    Pair u = q.remove();

	    for (int i = 0; i < 4; i++)
	    {
		int tx = u.x + dx[i], ty = u.y + dy[i];
		if(!isValid(tx, ty))
		    continue;
		Pair p = new Pair(tx, ty,u.n+1);
		if(grid[tx][ty] != '~' && grid[tx][ty] != '*')
		{
		    if(grid[tx][ty] != '.'){
			dist[map.get(p.x*h+p.y)][s] = p.n;
			dist[s][map.get(p.x*h+p.y)] = p.n;
		    }
		    grid[tx][ty] = '~';
		    q.add(p);
		}
	    }
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    h = bf.nextInt(); w = bf.nextInt();
	    if(h + w == 0)
		break;
	    char [][] org = new char[h][w];
	    for (int i = 0; i < org.length; i++)
	    {
		org[i] = bf.nextLine().toCharArray();
	    }
	    V = 1;
	    map = new HashMap<Integer,Integer>();
	    boolean flag = true;
	    for (int i = 0; i < h && flag; i++)
	    {
		for (int j = 0; j < w && flag; j++)
		{
		    char c = org[i][j];
		    if(c == '#') org[i][j] = '~';
		    else if(c == '*') {
			for (int k = 0; k < dx.length; k++)
			{
			    int tx = i + dx[k], ty = j + dy[k];
			    if(isValid(tx, ty))
				if(org[tx][ty] == '.')
				    org[tx][ty] = '~';
				else if(org[tx][ty] == '!' || org[tx][ty] == '@')
				    flag = false;
			}
		    }
		    else if(c == '!') {
			map.put(i*h+j, V++);
		    }
		    else if(c == '@')
			map.put(i*h+j, 0);
		}
	    }
	    if(!flag){
		out.println(-1);
		continue;
	    }
	    dist = new int[V][V];
	    for (int i = 0; i < V; i++)
	    {
		Arrays.fill(dist[i], INF);
		dist[i][i] = 0;
	    }
	    for (int i = 0; i < h; i++)
	    {
		for (int j = 0; j < w; j++)
		{
		    if(org[i][j] == '@' || org[i][j] == '!'){
			grid = new char[h][w];
			for (int j2 = 0; j2 < org.length; j2++)
			{
			    grid[j2] = Arrays.copyOf(org[j2], w);
			    //			    out.println(Arrays.toString(grid[j2]));
			}
			//			out.println();
			s = map.get(i*h+j);
			dist[s][s] = 0;
			bfs(i,j);	
		    }
		}
	    }
	    //	    for (int i = 0; i < V; i++)
	    //	    {
	    //		out.println(Arrays.toString(dist[i]));
	    //	    }
	    memo = new int[1<<V][V];
	    for (int i = 0; i < memo.length; i++)
		Arrays.fill(memo[i], -1);
	    int ans = dp(0,0);
	    out.println(ans == INF?-1:ans);
	}
	out.flush();
	out.close();
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
