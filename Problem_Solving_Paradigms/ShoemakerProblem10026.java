package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShoemakerProblem10026 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    int n = bf.nextInt();
	    Job [] j = new Job[n];
	    for (int i = 0; i < j.length; i++)
	    {
		j[i] = new Job(bf.nextInt(), bf.nextInt(),i);
	    }
	    Arrays.sort(j);
	    for (int i = 0; i < j.length; i++)
	    {
		out.print((i > 0?" ":"") + (j[i].i+1));
	    }
	    out.println();
	    if(TC > 0) out.println();
	}
	out.flush();
	out.close();
    }
    static class Job implements Comparable<Job>{
	int t,p,i;
	public Job(int t,int p, int i){
	    this.t = t;
	    this.p = p;
	    this.i = i;
	}
	@Override
	public int compareTo(Job o)
	{
	    int fir = t*o.p, sec = o.t*p;
	    return fir>sec?1:fir==sec?i - o.i:-1;
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