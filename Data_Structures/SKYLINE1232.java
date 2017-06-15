package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class SKYLINE1232 {

    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int tc = bf.nextInt();
	while(tc-- > 0){
	    int n = bf.nextInt();
	    SegmentTree sg = new SegmentTree();
	    int over = 0;
	    for(int i = 1; i <= n; i++)
	    {
		int L = bf.nextInt()+1, R = bf.nextInt(), H = bf.nextInt();
		over += sg.query(L, R, H);
		sg.update_range(L, R, H);
	    }
	    out.println(over);
	}
	bf.nextLine();
	out.flush();
	out.close();
    }

    static class Node{
	int min; 
	int max;
	public Node(int a, int b){
	    min = a;
	    max = b;
	}
    }
    static class SegmentTree {		// 1-based DS, OOP

	int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	Node [] sTree;
	int [] lazy;

	SegmentTree()		
	{
	    N = 1<<17;
	    sTree = new Node[N<<1];
	    for (int i = 0; i < N<<1; i++)
	    {
		sTree[i] = new Node(0,0);
	    }
	    lazy = new int[N<<1];
	}

	void update_range(int i, int j, int val)		// O(log n) 
	{
	    update_range(1,1,N,i,j,val);
	}

	void update_range(int node, int b, int e, int i, int j, int val)
	{
	    if(i > e || j < b)		
		return;
	    if(b >= i && e <= j)		
	    {
		Node c = sTree[node];
		c.max = Math.max(c.max, val);			
		c.min = Math.max(c.min, val);			
		lazy[node] = Math.max(lazy[node], val);		
	    }	
	    else{
		propagate(node, b, e);
		update_range(node<<1,b,(b+e)/2,i,j,val);
		update_range((node<<1)+1,(b+e)/2+1,e,i,j,val);
		sTree[node] = new Node(Math.min(sTree[node<<1].min, sTree[(node<<1)+1].min),Math.max(sTree[node<<1].max, sTree[(node<<1)+1].max));		
	    }

	}


	void propagate(int node, int b, int e)		
	{
	    update_range(node<<1,b,(b+e)/2,b,e,lazy[node]);
	    update_range((node<<1)+1,(b+e)/2+1,e,b,e,lazy[node]);
	    lazy[node] = 0;
	}

	int query(int i, int j, int val)
	{
	    return query(1,1,N,i,j, val);
	}

	int query(int node, int b, int e, int i, int j, int val)	// O(log n)
	{
	    if(i>e || j <b)
		return 0;		
	    if(b>= i && e <= j)
	    {
		if(val < sTree[node].min)
		    return 0;
		else if(val >= sTree[node].max)
		    return e - b + 1;
	    }
	    propagate(node, b, e);
	    int q1 = query(node<<1,b,(b+e)/2,i,j,val);
	    int q2 = query((node<<1)+1,(b+e)/2+1,e,i,j,val);
	    return q1 + q2;	

	}
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

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

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

	public boolean ready() throws IOException {return br.ready();}
    }
}
