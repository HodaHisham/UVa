package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class EvenParity11464 {
    static int [] mat;
    static final int INF = (int)1e9;
    static int ans;

    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	int cases = 1;
	while(t-- > 0){
	    int n = bf.nextInt();
	    mat = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		for (int j = 0; j < n; j++)
		{
		    mat[i] |= bf.nextInt()<<j;
		}
	    }
	    ans = INF;
	    for (int i = 0; i < 1<<n; i++)
	    {
		int mask = i;
		int tmp = 0; int last = -1;
		boolean flag = true;
		for (int j = 0; j < n; j++)
		{
		    if((mask | mat[j]) != mask){
			flag = false;
			break;
		    }
		    tmp += Integer.bitCount(mat[j]^mask);
		    int nxt = 0;
		    for (int k = 0; k < n; k++)
		    {
			int num = 0;
			if(k > 0 && (mask & 1<<(k-1))!=0)
			    num++;
			if(k < n-1 && (mask & 1<<(k+1))!=0)
			    num++;
			if(j > 0 && (last & 1<<k)!=0)
			    num++;
			if((num & 1) != 0)
			    nxt |= 1<<k;
		    }
		    last = mask;
		    mask = nxt;
		}
		if(flag)
		    ans = Math.min(ans, tmp);
	    }

	    out.println("Case " + cases++ + ": " + (ans>=INF?-1:ans));
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
	{    br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
    }
}
