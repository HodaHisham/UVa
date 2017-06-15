package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OnlyIdidit11222 {

public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	for (int cases = 1; cases <= TC; cases++)
	{
	    int [] occ = new int[10001]; // 0 unsolved 1,2,3 solved only by them, -1 more than 1 solved
	    for (int i = 1; i <= 3; i++)
	    {
		int s = bf.nextInt();
		for (int j = 0; j < s; j++)
		{
		    int tmp = bf.nextInt();
		    if(occ[tmp] == 0 || occ[tmp] == i)
			occ[tmp] = i;
		    else occ[tmp] = -1;
		}
	    }
	    ArrayList <Integer>[] adjList = new ArrayList[4];
	    for (int i = 0; i < adjList.length; i++)
	    {
		adjList[i] = new ArrayList<>();
	    }
	    for (int j = 0; j < occ.length; j++)
	    {
		if(occ[j]>0) adjList[occ[j]].add(j);
	    }
	    out.println("Case #"+cases+":");
	    int max = Math.max(adjList[1].size(), Math.max(adjList[2].size(), adjList[3].size()));
	    for (int i = 1; i < adjList.length; i++)
	    {
		if(adjList[i].size() == max){
		    out.print(i + " "+adjList[i].size());
		    for(int j:adjList[i])
			out.print(" "+j);
		    out.println();
		}
	    }
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