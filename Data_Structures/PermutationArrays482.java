package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PermutationArrays482 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    bf.nextLine();
	    StringTokenizer s = new StringTokenizer(bf.nextLine());
	    StringTokenizer arr = new StringTokenizer(bf.nextLine());
	    int [] a = new int[s.countTokens()];
	    String [] p = new String[arr.countTokens()];
	    String [] res = new String[s.countTokens()];
	    for (int i = 0; i < a.length; i++)
	    {
		a[i] = Integer.parseInt(s.nextToken())-1;
		p[i] = arr.nextToken();
	    }
	    for (int i = 0; i < a.length; i++)
	    {
		res[a[i]] = p[i];
	    }
	    for(String st : res)
		out.println(st);
	    if(TC > 0)
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