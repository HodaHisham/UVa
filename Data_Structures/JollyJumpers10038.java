package DataStructures;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JollyJumpers10038 {
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int n = bf.nextInt();
	    int prev = 0;
	    if(n > 0)
		prev = bf.nextInt();
	    boolean [] b = new boolean[n];
	    for (int i = 0; i < n-1; i++)
	    {
		int tmp = bf.nextInt();
		if(Math.abs(tmp-prev) < n)
		    b[Math.abs(tmp-prev)] = true;
		prev = tmp;
	    }
	    boolean ans = true;
	    for (int i = 1; i < b.length && ans; i++)
	    {
		ans &= b[i];
	    }
	    out.println(ans?"Jolly":"Not jolly");
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
