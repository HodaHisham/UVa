package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class TheNecklace10054 {
    static class Edge
    {
	int node;
	boolean used;

	Edge(int x) { node = x; }
    }
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
    static ArrayList<Edge>[] adjList;
    static LinkedList<Integer> tour;

    static void eulerTour(ListIterator<Integer> itr, int u)
    {
	for(Edge nxt: adjList[u])
	    if(!nxt.used)
	    {
		nxt.used = true;
		for(Edge rev: adjList[nxt.node])
		    if(!rev.used && rev.node == u){
			rev.used = true;
			break;
		    }
		itr.add(u);
		eulerTour(itr, nxt.node);
		itr.previous();
	    }

    }


    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	for (int c = 1; c <= TC; c++)
	{
	    int n = bf.nextInt();
	    UnionFind uf = new UnionFind(50);
	    adjList = new ArrayList[50];
	    int[]deg = new int[50];
	    for (int i = 0; i < 50; i++)
	    {
		adjList[i] = new ArrayList<Edge>();
	    }
	    int col = -1;
	    for (int i = 0; i < n; i++)
	    {
		int c1 = bf.nextInt()-1, c2 = bf.nextInt()-1;
		adjList[c1].add(new Edge(c2));
		adjList[c2].add(new Edge(c1));
                deg[c1]++;
                deg[c2]++;
		uf.unionSet(c1, c2);
		col = c1;
	    }
	    int sets = uf.numSets;
	    int odd = 0;
	    for (int i = 0; i < 50; i++)
	    {
		if((deg[i] & 1) != 0){
		    odd++;
		}
		if(deg[i] == 0)
		    sets--;
	    }
	    if(c > 1)
		out.println();
	    out.println("Case #"+c);
	    if(sets == 1 && odd == 0){
		tour = new LinkedList<Integer>();
		eulerTour(tour.listIterator(), col);
		tour.add(col);
		for (int i = 1; i < tour.size(); i++)
		{
		    out.println((tour.get(i-1)+1) + " " + (tour.get(i)+1));
		}
	    }
	    else{
		out.println("some beads may be lost");
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
