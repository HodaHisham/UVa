package Graphs;
import java.io.*; 
import java.util.*;

public class  TouristGuide10199 {


    static int N;

    static ArrayList<Integer>[] adjMatrix;
    static int root;
    static int rootChildren;
    static int counter;

    static int[] dfs_num;
    static int[] dfs_low;
    static int[] parent;
    static boolean[] visited;
    static boolean[] aPoints;
    public static void dfs(int u)
    {
	visited[u] = true;
	dfs_num[u] = dfs_low[u] = counter++;
	for(int i = 0; i < adjMatrix[u].size(); i++)
	{
	    int v = adjMatrix[u].get(i);
	    if(!visited[v])
	    {
		parent[v] = u;
		if(root==u)
		    rootChildren++;
		dfs(v);
		if(dfs_low[v]>=dfs_num[u])
		    aPoints[u] = true;
		dfs_low[u] = Math.min(dfs_low[u],dfs_low[v]);
	    }
	    else
	    {
		if(v!=parent[u])
		    dfs_low[u] = Math.min(dfs_low[u],dfs_num[v]);
	    }

	}
    }


    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException
    {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);		
	int cases = 0;
	while(true)
	{
	    N = sc.nextInt();
	    if(N==0)
		break;
	    if(cases > 0)
		out.println();
	    adjMatrix = new ArrayList[N];
	    TreeMap<Integer, String> tree = new TreeMap<Integer, String>();
	    TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	    for(int i = 0; i < N; i++)
		adjMatrix[i] = new ArrayList<Integer>();
	    for (int i = 0; i < N; i++){
		String s=  sc.next();
		tree.put(i, s);
		map.put(s, i);
	    }
	    int r = sc.nextInt();
	    for (int i = 0; i < r; i++)
	    {
		int u = map.get(sc.next());
		int v = map.get(sc.next());
		adjMatrix[u].add(v);
		adjMatrix[v].add(u);

	    }

	    dfs_num = new int[N];
	    dfs_low = new int[N];
	    parent = new int[N];
	    visited = new boolean[N];
	    aPoints = new boolean[N];

	    for(int i = 0; i < N; i++)
	    {
		if(!visited[i])
		{
		    root = i;
		    rootChildren = 0;
		    dfs(i);
		    if(rootChildren<=1)
			aPoints[root] = false;
		}
	    }
	    TreeSet<String> t = new TreeSet<String>();
	    for(int i = 0; i < N; i++)
		if(aPoints[i])
		    t.add(tree.get(i));
	    out.println("City map #" + (++cases) + ": " + t.size() +" camera(s) found");
	    for (Iterator<String> i = t.iterator(); i.hasNext();)
		out.println(i.next());
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