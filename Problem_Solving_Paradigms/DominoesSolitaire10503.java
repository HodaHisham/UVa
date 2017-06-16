
package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DominoesSolitaire10503 {

    static Pair [] dom; 
    static boolean [] taken;
    static int n;
    static boolean ans;
    public static void back(int ind, int prev){
	if(ind == n){
	    if(prev == dom[1].x)
		ans = true;
	    return;
	}

	for (int i = 2; i < dom.length; i++)
	{
	    if(!taken[i]){
		if(prev == dom[i].x){
		    taken[i] = true;
		    back(ind+1,dom[i].y);
		    taken[i] = false;
		}
		else if(prev == dom[i].y){
		    taken[i] = true;
		    back(ind+1,dom[i].x);
		    taken[i] = false;
		}
	    }
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    n = bf.nextInt();
	    if(n == 0)
		break;
	    int m = bf.nextInt();
	    dom = new Pair[m+2];
	    taken = new boolean[m+2];
	    for (int i = 0; i < dom.length; i++)
		dom[i] = new Pair(bf.nextInt(), bf.nextInt());
	    ans = false;
	    back(0,dom[0].y);
	    out.println(ans?"YES":"NO");
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int x; int y;
	public Pair(int x, int y){
	    this.x = x;
	    this.y = y;
	}
	public String toString(){
	    return x + " " + y;
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