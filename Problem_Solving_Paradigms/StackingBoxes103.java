package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StackingBoxes103 {

    static int k, n, boxes[][],memo[][]; static Pair seq[];
    static void shuffle(int[] a)
    {
	int n = a.length, tmp;
	for(int i = 0; i < n; ++i)
	{
	    int r = i + (int) (Math.random() * (n - i));
	    tmp = a[i];
	    a[i] = a[r];
	    a[r] = tmp;
	}
    }
    public static int dp(int ind, int prev){
	if(ind == k+1)
	    return 0;
	if(memo[ind][prev] != -1)
	    return memo[ind][prev];
	int ans = dp(ind+1,prev);
	boolean flag = true;
	int j = seq[ind].ind;
	for (int i = 0; i < n && flag; i++)
	{
	    if(boxes[j][i] <= boxes[prev][i])
		flag = false;
	}
	if(flag)
	    ans = Math.max(ans, 1+dp(ind+1,j));
	return memo[ind][prev] = ans;
    }
    static ArrayList<Integer> res;
    public static void print(int ind, int prev){
	if(ind == k+1)
	    return;
	int opt = dp(ind,prev);
	int ans = dp(ind+1,prev);
	if(opt == ans){
	    print(ind+1,prev);
	}
	else {
	    res.add(seq[ind].ind);
	    print(ind+1,seq[ind].ind);
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    k = bf.nextInt(); n = bf.nextInt();
	    boxes = new int[k+1][n];
	    memo = new int[k+2][k+2];
	    seq = new Pair[k+1];
	    seq[0] = new Pair(0, 0);
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i], -1);
	    }
	    for (int i = 1; i <= k; i++)
	    {
		for (int j = 0; j < n; j++)
		{
		    boxes[i][j] = bf.nextInt();
		}
		shuffle(boxes[i]);
		Arrays.sort(boxes[i]);
		seq[i] = new Pair(i,boxes[i][0]);
	    }
	    Arrays.sort(seq);
	    out.println(dp(1,0));
	    res = new ArrayList<Integer>();
	    print(1, 0);
	    for (int i = 0; i < res.size(); i++)
	    {
		out.print((i==0?"":" ") + res.get(i));
	    }
	    out.println();
	}
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int ind; int val;
	public Pair(int i, int v){
	    ind = i;
	    val = v;
	}
	@Override
	public int compareTo(Pair o)
	{
	    if(val == o.val)
		return ind - o.ind;
	    return val - o.val;
	}

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
