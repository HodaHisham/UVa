package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class AngryProgrammer11506 {
    static final int INF = (int)1e9;
    static int V, s, t, res[][];			//input
    static ArrayList<Integer>[] adjList;	//input
    static int[] ptr, dist;
    static int dinic()						//O(V^2E)
    {
	int mf = 0;
	while(bfs())
	{
	    ptr = new int[V];
	    int f;
	    while((f = dfs(s, INF)) != 0)
		mf += f;
	}
	return mf;
    }


    static boolean bfs()
    {
	dist = new int[V];
	Arrays.fill(dist, -1);
	dist[s] = 0;
	Queue<Integer> q = new LinkedList<Integer>();
	q.add(s);
	while(!q.isEmpty())
	{
	    int u = q.remove();
	    if(u == t)
		return true;
	    for(int v: adjList[u])
		if(dist[v] == -1 && res[u][v] > 0)
		{
		    dist[v] = dist[u] + 1;
		    q.add(v);
		}
	}
	return false;
    }

    static int dfs(int u, int flow)
    {
	if(u == t)
	    return flow;
	for(int i = ptr[u]; i < adjList[u].size(); i = ++ptr[u])
	{
	    int v = adjList[u].get(i);
	    if(dist[v] == dist[u] + 1 && res[u][v] > 0)
	    {
		int f = dfs(v, Math.min(flow, res[u][v]));
		if(f > 0)
		{
		    res[u][v] -= f;
		    res[v][u] += f;
		    return f;
		}
	    }
	}
	return 0;

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
    
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	Scanner sc = new Scanner(System.in);
	while(true){
	    int M = sc.nextInt();
	    int W = sc.nextInt();
	    if(M == 0 && W == 0)
		break;
	    V = M*2;
	    adjList = new ArrayList[V];
	    for (int i = 0; i < V; i++)
		adjList[i] = new ArrayList<Integer>();
	    res = new int[V][V];
	    for (int i = 0; i < M-2; i++)
	    {
		int numV = sc.nextInt()-1;
		int c = sc.nextInt();;
		adjList[numV*2].add(numV*2+1);
		res[numV*2][numV*2+1] = c;
	    }
	    for (int i = 0; i < W; i++)
	    {
		int j = sc.nextInt()-1;
		int k = sc.nextInt()-1;
		int d = sc.nextInt();;
		adjList[j*2+1].add(k*2);
		adjList[k*2].add(j*2+1);
		adjList[k*2+1].add(j*2);
		adjList[j*2].add(k*2+1);
		res[j*2+1][k*2] = d;
		//res[k*2][j*2+1] = d;
		res[k*2+1][j*2] = d;
		//res[j*2][k*2+1] = d;
	    }
	    s = 1;
	    t = 2*(M-1);
	    out.println(dinic());
	}
	out.flush();
	out.close();
    }


    
}
/**
4 4
3 5
2 2 
1 2 3
1 3 3 
2 4 1 
3 4 3 
4 4 
3 2 
2 2 
1 2 3 
1 3 3 
2 4 1
3 4 3
0 0
**/ 