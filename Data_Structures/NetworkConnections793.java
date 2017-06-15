package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NetworkConnections793{ 
    static class UnionFind {                                              
	int[] p, rank, setSize;
	int numSets;

	public UnionFind(int N) 
	{
	    p = new int[numSets = N];
	    rank = new int[N];
	    setSize = new int[N];
	    for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
	}

	public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

	public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public void unionSet(int i, int j) 
	{ 
	    if (isSameSet(i, j)) 
		return;
	    numSets--; 
	    int x = findSet(i), y = findSet(j);
	    if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
	    else
	    {	p[x] = y; setSize[y] += setSize[x];
	    if(rank[x] == rank[y]) rank[y]++; 
	    } 
	}

	public int numDisjointSets() { return numSets; }

	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
    }
    public static void main(String[]args) throws IOException{
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	while(t-->0){
	    int n = bf.nextInt();
	    UnionFind uf = new UnionFind(n);
	    int fail = 0;
	    int succ = 0;
	    while(true)
	    {
		String s = bf.nextLine();
		if(s == null || s.isEmpty())
		    break;
		StringTokenizer st = new StringTokenizer(s);
		char c = st.nextToken().charAt(0);
		int u = Integer.parseInt(st.nextToken())-1, v = Integer.parseInt(st.nextToken())-1;
		if(c == 'c'){
		    uf.unionSet(u, v);
		}
		else{
		    if(uf.isSameSet(u, v))
			succ++;
		    else fail++;
		}
	    }
	    out.println(succ+","+fail);
	    if(t > 0)
		out.println();
	}
	out.flush();
	out.close();
    }
    static class Scanner{
	BufferedReader bf;
	StringTokenizer st;
	public Scanner(InputStream s){
	    bf = new BufferedReader(new InputStreamReader(s));
	}
	public Scanner(FileReader s){
	    bf = new BufferedReader(s);
	}
	public String next() throws IOException{
	    while(st == null || !st.hasMoreTokens())
		st = new StringTokenizer(bf.readLine());
	    return st.nextToken();
	}
	public String nextLine() throws IOException{
	    return bf.readLine();
	}
	public int nextInt() throws NumberFormatException, IOException{
	    return Integer.parseInt(next());
	}
	public boolean ready() throws IOException{
	    return bf.ready();
	}
    }
}