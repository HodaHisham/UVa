package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PageHopping821 {

    static int INF = (int)1e9;
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
	    int a = bf.nextInt(), b = bf.nextInt();
	    if(a == 0 && b == 0)
		break;
	    ArrayList<Pair> arr = new ArrayList<Pair>();
	    int count = 0;
	    a--; b--;
	    map.put(a,count++);
	    map.put(b,count++);
	    arr.add(new Pair(map.get(a), map.get(b)));
	    while(true){
		a = bf.nextInt(); b = bf.nextInt();
		if(a == 0 && b == 0)
		    break;
		a--; b--;
		if(!map.containsKey(a))
		    map.put(a,count++);
		if(!map.containsKey(b))
		    map.put(b,count++);
		arr.add(new Pair(map.get(a), map.get(b)));
	    }
	    int n = map.size();
	    int [][] adjMat = new int[n][n];
	    for (int i = 0; i < adjMat.length; i++)
	    {
		for (int j = 0; j < adjMat.length; j++)
		{
		    adjMat[i][j] = i==j?0:INF;
		}
	    }
	    for (int i = 0; i < arr.size(); i++)
	    {
		int u = arr.get(i).x, v = arr.get(i).y;
		adjMat[u][v] = 1;
	    }
	    for (int k = 0; k < adjMat.length; k++)
		for (int i = 0; i < adjMat.length; i++)
		    for (int j = 0; j < adjMat.length; j++)
			adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k]+adjMat[k][j]);

	    int ans = 0;
	    for (int i = 0; i < adjMat.length; i++)
	    {
		for (int j = 0; j < adjMat.length; j++)
		{
		    ans += adjMat[i][j];
		}
	    }
	    out.printf("Case %d: average length between pages = %.3f clicks\n",cases++,(double)ans/(n*(n-1)));
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int x; int y;
	public Pair(int x,int y){
	    this.x = x;
	    this.y = y;
	}
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
