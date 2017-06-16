package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ColorGame10097 {
    static int V, color[], N1,N2,N3, INF = (int)1e9, minMoves;
    static int adjMat[][];
    static int [][] visited;
    public static void bfs(int s, int t)
    {
	Queue<Pair> q = new LinkedList<Pair>();
	q.add(new Pair(s,t));
	visited[s][t] = 0;
	while(!q.isEmpty())
	{
	    Pair u = q.remove();
	    if(u.n1 == N3 || u.n2 == N3){
		minMoves = visited[u.n1][u.n2];
		break;
	    }
	    
	    int v = adjMat[u.n1][u.n2]; //moving N1
	    if(visited[v][u.n2] == -1 && v != 0 && v != u.n1)
	    {
		visited[v][u.n2] = visited[u.n1][u.n2] +1;
		q.add(new Pair(v,u.n2));
		
	    }

	    v = adjMat[u.n2][u.n1]; // moving N2
	    if(visited[u.n1][v] == -1 && v != 0 && v != u.n2)
	    {
		visited[u.n1][v] = visited[u.n1][u.n2] +1;
		q.add(new Pair(u.n1,v));
	    }
	    
	}

    }
    /** 5 5
10 10 20 12 13
0 1 9
0 2 8
1 2 1
1 3 11
2 3 7
2
10 0 3
20 1 4
**/
     /* @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	PrintWriter out = new PrintWriter(System.out);
	Scanner sc = new Scanner(System.in);
	int games = 1;
	while(true){
	    V = sc.nextInt();
	    if(V == 0)
		break;
	    V++;
	    adjMat = new int[V][V];
	    visited = new int[V][V];
	    for (int i = 0; i < V; i++)
	    {
		Arrays.fill(visited[i], -1);
	    }
	    for (int i = 1; i < V; i++)
		for (int j = 1; j < V; j++)
		    adjMat[i][j] = sc.nextInt();

	    N1 = sc.nextInt();
	    N2 = sc.nextInt();
	    N3 = sc.nextInt();
	    out.println("Game #"+ (games++));
	    minMoves = INF;
	    bfs(N1,N2);
	    if(minMoves < INF)
		out.println("Minimum Number of Moves = " + minMoves);
	    else
		out.println("Destination is Not Reachable !");
	    out.println();
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int n1;
	int n2;
	public Pair(int s, int t){
	    n1 = s;
	    n2 = t;
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
