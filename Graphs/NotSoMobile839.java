package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NotSoMobile839 {

    static Scanner bf;
    
    static int read() throws IOException{
	int wl = bf.nextInt(), dl = bf.nextInt();
	int wr = bf.nextInt(), dr = bf.nextInt();
	int ans = -1;
	if(wl == 0)
	{
	    int t = read();
	    if(t != -1)
		ans = t;
	}
	else ans = wl;
	if(wr == 0)
	{
	    int t = read();
	    if(t != -1 && dr*t == ans*dl)
		ans += t;
	    else ans = -1;
	}
	else 
	    if(dr*wr == ans*dl) ans += wr;
	    else ans = -1;
	return ans;
    }
  
    public static void main(String[] args) throws Exception
    {
	bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-- > 0){
	    out.println(read() != -1?"YES":"NO");
	    if(TC != 0)
		out.println();
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