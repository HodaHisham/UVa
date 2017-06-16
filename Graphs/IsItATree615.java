package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IsItATree615 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int k = 1;
	while(true)
	{
	    boolean flag = true;
	    int u = bf.nextInt(), v = bf.nextInt();
	    if(u < 0 && v < 0)
		break;
	    else if(u + v == 0){
		out.println("Case "+k++ + " is a tree.");
		continue;
	    }
	    ArrayList <ArrayList<Integer>> adjList = new ArrayList <ArrayList<Integer>>();
	    HashMap<Integer, Integer> mp = new HashMap<>();
	    HashMap<Integer, Integer> deg = new HashMap<>();
	    int count = 0;
	    u--; v--;
	    if(!mp.containsKey(u)){ adjList.add(new ArrayList<>()); mp.put(u, count++); }
	    if(!mp.containsKey(v)){ adjList.add(new ArrayList<>()); mp.put(v, count++); }
	    u = mp.get(u);
	    v = mp.get(v);
	    adjList.get(u).add(v);
	    deg.put(v, !deg.containsKey(v)?1:deg.get(v)+1);
	    while(true)
	    {
		u = bf.nextInt()-1; v = bf.nextInt()-1;
		if(u == -1 && v == -1)
		    break;
		if(!mp.containsKey(u)){ adjList.add(new ArrayList<>()); mp.put(u, count++); }
		if(!mp.containsKey(v)){ adjList.add(new ArrayList<>()); mp.put(v, count++); }
		v = mp.get(v);
		u = mp.get(u);
		adjList.get(u).add(v);
		deg.put(v, deg.containsKey(v)?deg.get(v)+1:1);
	    }
	    int root = -1, num = 0;
	    for (int i:mp.keySet())
	    {
		if(!deg.containsKey(mp.get(i))){
		    root = mp.get(i);
		    num++;
		    //		    out.println(i + " " + mp.get(i));
		}
	    }
	    flag &= num == 1;
	    boolean [] vis = new boolean[count];
	    if(root != -1){
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		vis[root] = true;
		while(!q.isEmpty() && flag)
		{
		    u = q.remove();
		    for(int j:adjList.get(u)){
			if(!vis[j]){
			    vis[j] =  true;
			    q.add(j);
			}
			else flag = false;
		    }
		}
	    }
	    for (int i = 0; i < vis.length && flag; i++)
	    {
		flag &= vis[i];
	    }
	    out.println("Case "+k++ + " is "+ (flag?"":"not ")+"a tree.");
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