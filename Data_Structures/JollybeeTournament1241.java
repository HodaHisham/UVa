package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class JollybeeTournament1241 {
    static class SegmentTree {		// 1-based DS, OOP

	int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	int[] array; Node[]sTree;

	SegmentTree(int[] in)		
	{
	    array = in; N = in.length - 1;
	    sTree = new Node[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
	    build(1,1,N);
	}

	void build(int node, int b, int e)	// O(n)
	{
	    if(b == e)					
		sTree[node] = new Node(array[b],array[b]==1?1:0);
	    else						
	    {
		int mid = b + e >> 1;
	    build(node<<1,b,mid);
	    build(node<<1|1,mid+1,e);
	    Node r = sTree[node<<1];
	    Node l = sTree[node<<1|1];
	    int s = r.val+l.val;
	    int d = Math.abs(r.val - l.val);
	    int val = d == 0?s==4?2:0:d==1?s==1?0:1:1;
	    sTree[node] = new Node(val, r.sum+l.sum+(val==1?1:0));
	    }
	}
    }
    public static void main(String[] args) throws Exception {

	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int T = bf.nextInt();
	while(T-->0){
	    int n = 1<<(bf.nextInt()-1);
	    int m = bf.nextInt();
	    int[]in = new int[n+1];
	    for (int i = 0; i < m; i++)
	    {
		in[(bf.nextInt()-1)/2+1]++;
	    }
	    SegmentTree sg = new SegmentTree(in);
//	    out.println(Arrays.toString(sg.sTree));
	    out.println(sg.sTree[1].sum);
	}

	out.flush();
	out.close();
    }
    static class Node{
	int val;
	int sum;
	public Node(int v,int s){
	    val = v;
	    sum = s;
	}
	public String toString(){
	    return val +" "+sum; 
	}
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

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

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}
    }
}
