package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class FrequentValues11235 {
    static class newType {
	int a;
	int b;
	public newType(int a,int b){
	    this.a = a;
	    this.b = b;

	}
    }
    static class Pair {
	int val;
	int count;
	newType right;
	newType left;
	public Pair(int a,int b, newType c, newType d){
	    val = a;
	    count = b;
	    right = c;
	    left = d;
	}
    }
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    int q = bf.nextInt();
	    int N = 1; while(N < n) N <<= 1; //padding
	    int[] in = new int[N + 1];
	    for(int i = 1; i <= n; i++)
		in[i] = bf.nextInt();

	    SegmentTree sg = new SegmentTree(in);
	    for (int i = 0; i < q; i++)
	    {
		out.println(sg.query(bf.nextInt(), bf.nextInt()).count);
	    }
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
    static class SegmentTree {		// 1-based DS, OOP

	int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	int[] array;
	Pair[]sTree;

	SegmentTree(int[] in)		
	{
	    array = in; N = in.length - 1;
	    sTree = new Pair[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
	    build(1,1,N);
	}

	void build(int node, int b, int e)	// O(n)
	{
	    if(b == e)					
		sTree[node] = new Pair(array[b],1,new newType(array[b],1),new newType(array[b],1));
	    else						
	    {
		build(node<<1,b,(b+e)/2);
		build((node<<1)+1,(b+e)/2+1,e);
		Pair ans = null;
		Pair l = sTree[node<<1];
		Pair r = sTree[(node<<1)+1];
		if(r.left.a == l.right.a){
		    if(r.left.b + l.right.b > r.count)
			if(r.left.b + l.right.b > l.count)
			    ans = new Pair(r.left.a,r.left.b + l.right.b,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
			else
			    ans = new Pair(l.val,l.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
		    else
			if(r.count > l.count)
			    ans = new Pair(r.val,r.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
			else
			    ans = new Pair(l.val,l.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));

		}
		else if(r.count > l.count)
		    ans = new Pair(r.val,r.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
		else
		    ans = new Pair(l.val,l.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
		sTree[node] = ans;
	    }
	}

	Pair query(int i, int j)
	{
	    return query(1,1,N,i,j);
	}

	Pair query(int node, int b, int e, int i, int j)	// O(log n)
	{
	    if(i>e || j <b)
		return new Pair(0,0,new newType(0, 0),new newType(0, 0));		
	    if(b>= i && e <= j)
		return new Pair(sTree[node].val,sTree[node].count,sTree[node].right,sTree[node].left);
	    Pair l = query(node<<1,b,(b+e)/2,i,j);
	    Pair r = query((node<<1)+1,(b+e)/2+1,e,i,j);
	    Pair ans = null;
	    if(r.left.a == l.right.a){
		if(r.left.b + l.right.b > r.count)
		    if(r.left.b + l.right.b > l.count)
			ans = new Pair(r.left.a,r.left.b + l.right.b,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
		    else
			ans = new Pair(l.val,l.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
		else
		    if(r.count > l.count)
			ans = new Pair(r.val,r.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
		    else
			ans = new Pair(l.val,l.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));

	    }
	    else if(r.count > l.count)
		ans = new Pair(r.val,r.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
	    else
		ans = new Pair(l.val,l.count,new newType(r.right.a, r.right.a == l.right.a?r.right.b+l.right.b:r.right.b),new newType(l.left.a, r.left.a == l.left.a?r.left.b+l.left.b:l.left.b));
	    return ans;

	}
    }

}
