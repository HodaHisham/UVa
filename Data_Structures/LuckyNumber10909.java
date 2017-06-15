package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuckyNumber10909 {

    static class SegmentTree {		// 1-based DS, OOP

	int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	int[] array, sTree;

	SegmentTree(int [] in)		
	{
	    N = in.length-1;
	    array = in; 
	    sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
	    build(1,1,N);
	}

	void build(int node, int b, int e)	// O(n)
	{
	    if(b == e)					
		sTree[node] = array[b];
	    else						
	    {
		int mid = b + e >> 1;
	    build(node<<1,b,mid);
	    build(node<<1|1,mid+1,e);
	    sTree[node] = sTree[node<<1]+sTree[node<<1|1];
	    }
	}

	int get(int k, int b, int e, int node){
	    if(b == e) return b;
	    int mid = b + e >> 1;
//	    System.out.println(b + " "+e+" "+k +" "+sTree[node<<1]);
	    if(sTree[node<<1] >= k) return get(k,b,mid,node<<1);
	    return get(k-sTree[node<<1],mid+1,e,node<<1|1);
	}
	int del(int k, int b, int e, int node){
	    sTree[node]--;
	    if(b == e) return b;
	    int mid = b + e >> 1;
	    if(sTree[node<<1] >= k) return del(k,b,mid,node<<1);
	    return del(k-sTree[node<<1],mid+1,e,node<<1|1);
	}
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = 2000001;
	int N = 1; while(N < n) N <<= 1; //padding
	int [] in = new int[N+1];
	for (int i = 1; i < n; i+=2)
	{
	    in[i] = 1;
	}
	SegmentTree sg = new SegmentTree(in);
	boolean [] isLucky = new boolean[n];
	isLucky[1] = true;
	int av = sg.sTree[1];
	//	out.println(Arrays.toString(sg.sTree));
	for (int i = 2; i <= av; i++)
	{
	    int tmp = sg.get(i, 1, N, 1); int sum = tmp; 
//	    out.println(tmp);
	    isLucky[tmp] = true;
	    for (int j = 0; sum-j <= av; j++)
	    {
		sg.del(sum-j, 1, N, 1);
		av--; sum += tmp;
	    }
	}
	//	out.println(Arrays.toString(sg.sTree));
	while(bf.ready()){
	    int num = bf.nextInt();
	    int ans = -1;
	    int con = num/2;
	    if((num & 1) == 0)
		for (int i = con; i >= 0; i--)
		{
		    if(isLucky[i] && isLucky[num-i]){
			ans = i;
			break;
		    }
		}
	    if(ans == -1) out.println(num+" is not the sum of two luckies!");
	    else out.println(num + " is the sum of "+ans+" and "+(num-ans)+".");
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
