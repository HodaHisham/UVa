package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class NumberMaze929 {
    static final int INF = (int)1e9;	//don't increase, avoid overflow
    static int [][] grid;
    static int dijkstra()	//O(E log E)
    {
	int[][] dist = new int[n][m];
	for (int i = 0; i < dist.length; i++)
	    Arrays.fill(dist[i], INF);

	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	dist[0][0] = grid[0][0];
	pq.add(new Edge(0,0, dist[0][0]));						
	while(!pq.isEmpty())
	{
	    Edge cur = pq.remove();
	    if(cur.x == n-1 && cur.y == m-1)						
		return dist[n-1][m-1];
	    if(cur.cost > dist[cur.x][cur.y])		
		continue;
	    for (int i = 0; i < dx.length; i++)
	    {
		if(isValid(cur.x+dx[i], cur.y+dy[i])){
		    if(cur.cost + grid[cur.x+dx[i]][cur.y+dy[i]] < dist[cur.x+dx[i]][cur.y+dy[i]])
			pq.add(new Edge(cur.x+dx[i], cur.y+dy[i], dist[cur.x+dx[i]][cur.y+dy[i]] = cur.cost + grid[cur.x+dx[i]][cur.y+dy[i]]));
		}
	    }
	}
	return -1;
    }
    static class Edge implements Comparable<Edge>
    {
	int x, y, cost;

	Edge(int a, int b, int c) { x = a; y = b; cost = c; }

	public int compareTo(Edge e){ return cost - e.cost;	}
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    public static boolean isValid(int x , int y){
	return x >= 0 && x < n && y >= 0 && y < m;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    n = bf.nextInt(); m = bf.nextInt();
	    grid = new int[n][m];
	    for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
		    grid[i][j] = bf.nextInt();
	    out.println(dijkstra());
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
