package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Forrest599{ 
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
	    ArrayList<String> inp = new ArrayList<String>();
	    while(true){
		String s = bf.next();
		if(s.startsWith("*"))
		    break;
		inp.add(s);
	    }
	    HashMap<Character, Integer> map = new HashMap<Character,Integer>();
	    HashSet<Integer> set = new HashSet<Integer>();
	    StringTokenizer st = new StringTokenizer(bf.nextLine(), ",");
	    int count = 0;
	    
	    while(st.hasMoreTokens()){
		map.put(st.nextToken().charAt(0), count);
		set.add(count++);
	    }
	    if(count > 0){
		UnionFind uf = new UnionFind(count);
		for (int i = 0; i < inp.size(); i++)
		{
		    char [] c = inp.get(i).toCharArray();
		    int u = map.get(c[1]), v = map.get(c[3]);
		    uf.unionSet(u,v);
		    set.remove(u);
		    set.remove(v);
		}
		out.printf("There are %d tree(s) and %d acorn(s).\n", uf.numSets-set.size(),set.size());
	    }
	    else 
		out.println("There are 0 tree(s) and 0 acorn(s).");
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