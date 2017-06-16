package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewToBengladesh10525 {
    static Pair [][]adjMat;
    static int INF = (int)1e9;
    static int x;
    public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int n = sc.nextInt();
	while(n-->0 ){
	    x = sc.nextInt();
	    int y = sc.nextInt();
	    adjMat = new Pair[x][x];
	    for (int i = 0; i < x; i++)
	    {
		for (int j = 0; j < x; j++)
		{
		    if(i == j)
			adjMat[i][j] = new Pair(0,0);
		    else
			adjMat[i][j] = new Pair(INF,INF);
		}
	    }
	    for (int i = 0; i < y; i++)
	    {
		int a = sc.nextInt()-1;
		int b = sc.nextInt()-1;
		int time = sc.nextInt();
		int dist = sc.nextInt();
		if(adjMat[a][b].time > time){
		    adjMat[a][b] = new Pair(time,dist);
		    adjMat[b][a] = new Pair(time,dist);
		}
		else if(adjMat[a][b].time == time && adjMat[a][b].dist > dist){
		    adjMat[a][b] = new Pair(time,dist);
		    adjMat[b][a] = new Pair(time,dist);
		}
	    }
	    for (int k = 0; k < x; k++)
	    {
		for (int i = 0; i < x; i++)
		{
		    for (int j = 0; j < x; j++)
		    {
			if(adjMat[i][j].time > adjMat[i][k].time + adjMat[k][j].time){
			    adjMat[i][j].time = adjMat[i][k].time + adjMat[k][j].time;
			    adjMat[i][j].dist = adjMat[i][k].dist + adjMat[k][j].dist;
			}
			else if(adjMat[i][j].time == adjMat[i][k].time + adjMat[k][j].time && adjMat[i][j].dist > adjMat[i][k].dist + adjMat[k][j].dist)
			    adjMat[i][j].dist = adjMat[i][k].dist + adjMat[k][j].dist;
		    }
		}
	    }

	    int q = sc.nextInt();
	    for (int i = 0; i < q; i++)
	    {
		int s = sc.nextInt()-1;
		int d = sc.nextInt()-1;
                if(adjMat[s][d].dist == INF)
                    out.println("No Path.");
                else
                    out.println("Distance and time to reach destination is " + adjMat[s][d].dist + " & " + adjMat[s][d].time + "." );
	    }
	    if(n > 0) out.println();
	    
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int dist;
	int time;
	public Pair(int t,int d){
	    dist = d;
	    time = t;
	}
    }
    static class Scanner {
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
