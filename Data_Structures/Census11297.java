package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Census11297 {
    static class SegmentTree {		// 1-based DS, OOP
	static final int INF = (int)2e9;
	int N,n; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	int[] mat[],min,max;

	SegmentTree(int[][] in, int s)		
	{
	    mat = in; N = in.length - 1; n = s;
	    max = new int[350000];	
	    min = new int[350000];	 
	    Arrays.fill(min, INF); 
	    build(1,1,1,N);
	}

	void build(int node, int i, int j, int len)	// O(n)
	{
	    if(len == 1){
		if(i <= n && j <= n){		
		    min[node] = mat[i][j];
		    max[node] = mat[i][j];
		}
	    }
	    else						
	    {
		int len2 = len/2;
		int [] dx = {0,0,len2,len2};
		int [] dy = {0,len2,0,len2};
		for (int k = -2; k < 2; k++)
		    build((node<<2)+k,i+dx[k+2],j+dy[k+2],len2);
		min[node] = INF; max[node] = 0;
		for (int k = -2; k < 2; k++)
		{
		    min[node] = Math.min(min[node], min[(node<<2)+k]);
		    max[node] = Math.max(max[node], max[(node<<2)+k]);
		}
	    }	
	}

	void update_point(int i,int j, int val)			// O(log n)
	{
	    int node = findNode(1, 1, 1, N, i, j);			
	    min[node] = max[node] = val;			
	    while(node>1)				
	    {
		node = (node + 2)>>2;
		    min[node] = INF; max[node] = 0;
		    for (int k = -2; k < 2; k++)
		    {
			min[node] = Math.min(min[node], min[(node<<2)+k]);
			max[node] = Math.max(max[node], max[(node<<2)+k]);
		    }		
	    }
	}

	int findNode(int node, int i, int j, int len, int a, int b){
	    if(len == 1) return node;
	    int len2 = len/2;
	    if(a >= i + len2){
		if(b >= j + len2)
		    return findNode((node<<2)+1, i+len2, j+len2, len2, a, b);
		else
		    return findNode((node<<2), i+len2, j, len2, a, b);
	    }
	    else
		if(b >= j+len2)
		    return findNode((node<<2)-1, i, j+len2, len2, a, b);
	    return findNode((node<<2)-2,i,j,len2,a,b);
	}

	int [] query(int x1, int y1, int x2, int y2)
	{
	    return query(1,1,1,N,x1,y1,x2,y2);
	}

	int [] query(int node, int i, int j, int len, int x1, int y1, int x2, int y2)	// O(log n)
	{
	    int len2 = len/2;
	    if(x1 >= i+len || y1 >= j+len || x2 < i || y2 < j) //out of range
		return new int[] {0,INF};		
	    if(i >= x1 && j >= y1 && i+len-1 <= x2 && j+len-1 <= y2) //all included in range
		return new int[] {max[node],min[node]};
	    int [] res = {0,INF};
	    int [] dx = {0,0,len2,len2};
	    int [] dy = {0,len2,0,len2};
	    int [] tmp;
	    for (int k = -2; k < 2; k++)
	    {
		tmp = query((node<<2)+k,i+dx[k+2],j+dy[k+2],len2,x1,y1,x2,y2);
		res[0] = Math.max(res[0], tmp[0]);
		res[1] = Math.min(res[1], tmp[1]);
	    }
	    return res;	
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	int N = 1; while(N < n) N<<=1;
	int [][] mat = new int[N+1][N+1];
	for (int i = 1; i <= n; i++)
	{
	    for (int j = 1; j <= n; j++)
	    {
		mat[i][j] = bf.nextInt();
	    }
	}
	SegmentTree sg = new SegmentTree(mat,n);
	int q = bf.nextInt();
	for (int i = 0; i < q; i++)
	{
	    char c = bf.next().charAt(0);
	    if(c == 'q'){
		int x1 = bf.nextInt(), y1 = bf.nextInt(), x2 = bf.nextInt(), y2 = bf.nextInt();
		int [] query = sg.query(x1,y1,x2,y2);
		out.println(query[0] + " " + query[1]);
	    }
	    else{
		int x = bf.nextInt(), y = bf.nextInt(), v = bf.nextInt();
		sg.update_point(x,y,v);
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