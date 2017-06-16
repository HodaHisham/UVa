
package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CD624 {
    static ArrayList<Integer> ans;
    static int max,n,k;
    static int [] tracks;
    static boolean [] taken;
    public static void back(int sum,int ind){
	if(sum == n)
	{
	    max = n;
	    ans = new ArrayList<Integer>();
	    for (int i = 0; i < taken.length; i++)
	    {
		if(taken[i])
		    ans.add(tracks[i]);
	    }
	    return;
	}
	if(ind == k)
	{
	    if(max < sum){
		max = sum;
		ans = new ArrayList<Integer>();
		for (int i = 0; i < taken.length; i++)
		{
		    if(taken[i])
			ans.add(tracks[i]);
		}
	    }
	    return;
	}
	if(sum + tracks[ind] <= n){
	    taken[ind] = true;
	    back(sum+tracks[ind],ind+1);
	    taken[ind] = false;
	}
	back(sum,ind+1);
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    n = bf.nextInt();
	    k = bf.nextInt();
	    tracks = new int[k];
	    for (int i = 0; i < k; i++)
		tracks[i] = bf.nextInt();
	    taken = new boolean[k];
	    max = 0;
	    back(0,0);
	    for (int i = 0; i < ans.size(); i++)
	    {
		out.print(ans.get(i) + " ");
	    }
	    out.println("sum:"+max);
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
