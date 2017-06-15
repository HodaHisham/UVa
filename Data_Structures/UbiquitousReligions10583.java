package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UbiquitousReligions10583 {
    static class UnionFind {                                              
	int[] p, rank, setSize;
	int numSets;

	public UnionFind(int N) 
	{
	    p = new int[N];
	    rank = new int[N];
	    setSize = new int[N];
	    numSets = N;
	    for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
	}

	public int findSet(int i) 
	{ 
	    if (p[i] == i) return i;
	    else return p[i] = findSet(p[i]);
	}

	public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public void unionSet(int i, int j) 
	{ 
	    if (isSameSet(i, j)) 
		return;
	    numSets--; 
	    int x = findSet(i), y = findSet(j);
	    // rank is used to keep the tree short
	    if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
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
	int cases = 1;
	while(true){
	    int n = bf.nextInt();
	    int m = bf.nextInt();
	    if(n == 0 && m == 0)
		break;
	    UnionFind u = new UnionFind(n);
	    for (int i = 0; i < m; i++)
	    {
		u.unionSet(bf.nextInt()-1, bf.nextInt()-1);
	    }
	    out.println("Case "+cases++ +": " + u.numSets);
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

	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
	}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}


    }

}
