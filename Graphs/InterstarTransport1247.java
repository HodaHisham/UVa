package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class InterstarTransport1247 {
    static int INF = (int)1e9, adjMat [][], p[][],u,v;
    static PrintWriter out;
    static void floyd()
    {

	p = new int[26][26];	
	for(int i = 0; i < 26; i++)
	    for(int j = 0; j < 26; j++){
		p[i][j] = i;
	    }
	for(int k = 0; k < 26; k++)
	    for(int i = 0; i < 26; i++)
		for(int j = 0; j < 26; j++)
		    if(adjMat[i][j] > adjMat[i][k] + adjMat[k][j])
		    {
			adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
			p[i][j] = p[k][j];
		    }
		    else if(adjMat[i][j] == adjMat[i][k] + adjMat[k][j] && findPath(i,j) > findPath(i,k)+findPath(k,j))
		    {
			adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
			p[i][j] = p[k][j];
		    }

    }
    static int findPath(int i, int j)
    {
	int count = 0;
	if(i!=j) count = findPath(i,p[i][j])+1;
	return count;
    }
    static void printPath(int i, int j)
    {
	if(i!=j) printPath(i,p[i][j]);
	if(j==v)
	    out.print((char)(j+'A'));
	else
	    out.print((char)(j+'A')+" ");
    }

    public static void main(String[] args) throws Exception {
	out = new PrintWriter(System.out);
	Scanner sc = new Scanner(System.in);
	int s = sc.nextInt();
	int t = sc.nextInt();
	adjMat = new int[26][26];
	for (int i = 0; i < 26; i++)
	{
	    for (int j = 0; j < 26; j++)
	    {
		if(i == j)
		    adjMat[i][j] = 0;
		else
		    adjMat[i][j] = INF;
	    }
	}

	for (int i = 0; i < t; i++)
	{
	    int u = sc.next().charAt(0)-'A';
	    int v = sc.next().charAt(0)-'A';
	    int cost = sc.nextInt();
	    adjMat[u][v] = cost;
	    adjMat[v][u] = cost;
	}
	floyd();
	int n = sc.nextInt();
	for (int i = 0; i < n; i++)
	{
	     u = sc.next().charAt(0)-'A';
	     v = sc.next().charAt(0)-'A';
	    printPath(u,v);
	    out.println();
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
