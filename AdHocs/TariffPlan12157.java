package AdHocs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TariffPlan12157 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	StringBuilder sb = new StringBuilder();
	for (int i = 1; i <= TC; i++)
	{
	    int n = bf.nextInt();
	    int m = 0, j = 0;
	    for (int j2 = 0; j2 < n; j2++)
	    {
		int k = bf.nextInt()+1;
		int s = k/30 + (k%30==0?0:1);
		m += 10*s;
		s = k/60 + (k%60==0?0:1);
		j += 15*s;
	    }
	    sb.append("Case ").append(i).append(": ");
	    if(m <= j) sb.append("Mile ");
	    if(j <= m) sb.append("Juice ");
	    sb.append(Math.min(m, j));
//	    sb.append(m);
//	    sb.append(" ");
//	    sb.append(j);
	    sb.append("\n");
	}
	out.print(sb);
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