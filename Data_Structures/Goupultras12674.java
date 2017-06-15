package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Goupultras12674 {
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
        while(bf.ready()){
            int n = bf.nextInt();
            int N = 1;
            while(N < n) N<<=1;
            int [] h = new int[N+1];
            Arrays.fill(h,(int)1e9);
            for (int i = 0; i < n; i++)
		h[i] = bf.nextInt();
            SegmentTree sg = new SegmentTree(h);
            int [] left = new int[n];
            int [] right = new int[n];
            left[0] = -1;
            right[n-1] = -1;
            for (int i = 1; i < n; i++)
	    {
        	left[i] = i-1;
		while(left[i] != -1 && h[i] >= h[left[i]]){
		    left[i] = left[left[i]];
		}
	    }
            for (int i = n-2; i >= 0; i--)
	    {
		right[i] = i+1;
		while(right[i] != -1 && h[i] >= h[right[i]])
		    right[i] = right[right[i]];
	    }
            int num = 0;
            for (int i = 1; i < n-1; i++)
	    {
        	int ans = 0;
		if(right[i] != -1){
		    ans = sg.query(i+1, right[i]);
		}
		if(left[i] != -1){
		    ans = Math.max(ans, sg.query(left[i], i-1));
		}
		if(h[i] - ans >= 150000)
		{
		    out.print((num++ == 0 ? "":" ") + (i+1));
		}
	    }
            out.println();
        }
	out.flush();
	out.close();
    }

    static class SegmentTree {		// 1-based DS, OOP

	int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	int [] array, sTree;

	SegmentTree(int [] n)		
	{
	    array = n; N = n.length-1;
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
			sTree[node] = Math.min(sTree[node<<1],sTree[node<<1|1]);
		}
	}
	
	int query(int i, int j)
	{
	    return query(1,1,N,i,j);
	}

	
	int query(int node, int b, int e, int i, int j)	// O(log n)
	{
	    if(i>e || j <b)
		return (int)1e9;		
	    if(b>= i && e <= j)
		return sTree[node];
	    int mid = b + e >> 1;
	    int q1 = query(node<<1,b,mid,i,j);
	    int q2 = query(node<<1|1,mid+1,e,i,j);
	    return Math.min(q1 , q2);	

	}
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{ br = new BufferedReader(fileReader);	}

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
