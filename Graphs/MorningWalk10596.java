package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class MorningWalk10596 {
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
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int n = bf.nextInt();
	    UnionFind uf = new UnionFind(n);
	    int [][] deg = new int[n][n];
	    int r = bf.nextInt();
	    for (int i = 0; i < r; i++)
	    {
		int c1 = bf.nextInt(), c2 = bf.nextInt();
		deg[c1][c2]++; 
		deg[c2][c1]++; 
		uf.unionSet(c1, c2);
	    }
	    int sets = uf.numSets;
	    int odd = 0;
	    for (int i = 0; i < n; i++)
	    {
		int num = 0;
		for (int j = 0; j < n; j++)
		{ 
		    if(i != j){
			num += deg[i][j];
		    }
		}

		if((num & 1) != 0){
		    odd++;
		}
		if(num == 0)
		    sets--;
	    }
	    //	    	    out.println(even);
	    out.println(sets == 1 && odd == 0?"Possible":"Not Possible");
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
	public boolean ready() throws IOException{
	    return br.ready();
	}
    }
}
