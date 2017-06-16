package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AnotherCrisis12186 {
    static ArrayList<Integer> adjList[];
    
    static int t, n;
    public static int dp(int node){
	if(node == n+1)
	    return 0;
	if(adjList[node].size() == 0)
	    return 1;
	int T = (int) Math.ceil(t*adjList[node].size()/100.0);
	int [] val = new int[adjList[node].size()];
	for(int i = 0; i< val.length;i++){
	    val[i] = dp(adjList[node].get(i));
	}
	shuffle(val);
	Arrays.sort(val);
        int count = 0;
        for (int i = 0; i < T; i++)
	{
	    count += val[i];
	}
	return count;
    }
    static void shuffle(int[] a)
	{
		int n = a.length;
		for(int i = 0; i < n; i++)
		{
			int r = i + (int)(Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	     n = bf.nextInt();
	     t = bf.nextInt();
	    if(n == 0 && t == 0)
		break;
	    adjList = new ArrayList[n+1];
	    for (int i = 0; i < n+1; i++)
	    {
		adjList[i] = new ArrayList<Integer>();
	    }
	    for (int i = 1; i <= n; i++)
	    {
		adjList[bf.nextInt()].add(i);
	    }
	    
	    out.println(dp(0));
	}
	out.flush();
	out.close();
    }

    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{    br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
    }
}
