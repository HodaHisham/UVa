package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ordering872 {
    static ArrayList<String> ans;
    static ArrayList<Integer> adjList[];
    static int[] deg;
    static char [] var;
    public static void back(StringBuilder sb, int mask){
	if(mask == (1<<deg.length)-1){
	    ans.add(sb.toString());
	    return;
	}
	for (int i = 0; i < deg.length; i++)
	{
	    if(deg[i] == 0 && (mask & (1<<i)) == 0)
	    {
		for(int v:adjList[i])
		    deg[v]--;
		back(new StringBuilder(sb+" "+var[i]),mask | (1 << i));
		for(int v:adjList[i])
		    deg[v]++;
	    }
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	while(t-->0){
	    bf.nextLine();
	    StringTokenizer st = new StringTokenizer(bf.nextLine());
	    int count = 0;
	    HashMap<Character, Integer> map = new HashMap<Character,Integer>();
	    var = new char[st.countTokens()];
	    while(st.hasMoreTokens()){
		char c = st.nextToken().charAt(0);
		map.put(c, count);
		var[count++] = c;
	    }
	    st = new StringTokenizer(bf.nextLine());
	    deg = new int[count];
	    adjList = new ArrayList[count];
	    for (int i = 0; i < adjList.length; i++)
		adjList[i] = new ArrayList<Integer>();
	    while(st.hasMoreTokens()){
		String tmp = st.nextToken();
		int u = map.get(tmp.charAt(0)), v = map.get(tmp.charAt(2));
		if(!adjList[u].contains(v)){
		    adjList[u].add(v);
		    deg[v]++;
		}
	    }
	    ans = new ArrayList<String>();
	    back(new StringBuilder(),0);
	    Collections.sort(ans);
	    for (int i = 0; i < ans.size(); i++)
	    {
		out.println(ans.get(i).substring(1));
	    }
	    if(ans.size() == 0)
		out.println("NO");
	    if(t > 0)
		out.println();
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
