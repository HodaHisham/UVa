package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GasStations12321 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int l = bf.nextInt(); 
	    int g = bf.nextInt();
	    if(l == 0 && g == 0)
		break;
	    Pair [] stations = new Pair[g];
	    for (int i = 0; i < g; i++)
	    {
		int x = bf.nextInt(), r = bf.nextInt();
		stations[i] = new Pair(x-r, x+r);
	    }
	    Arrays.sort(stations);
	    int a = 0, ans = 0, point = 0;
	    while(a < l){
		int max = a;
		while(point < g && stations[point].left <= a)
		    max = Math.max(max, stations[point++].right);
		if(max == a)
		    break;
		a = max;
		ans++;
	    }
	    if(a < l)
		out.println(-1);
	    else
		out.println(g - ans);
	}
	out.flush();
	out.close();
    }
    static class Pair implements Comparable<Pair>{
	int left; int right;
	public Pair(int l , int r){
	    left = l; right = r;
	}
	@Override
	public int compareTo(Pair o)
	{
	    if(left == o.left)
		return o.right - right;
	    return left - o.left;
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
