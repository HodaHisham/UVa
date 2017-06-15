package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Newspaper11340 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    int k = bf.nextInt();
	    HashMap<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < k; i++)
	    {
		String [] s = bf.nextLine().split(" ");
		map.put(s.length==1?' ':s[0].charAt(0), Integer.parseInt(s.length==1?s[0]:s[1]));
	    }
	    int m = bf.nextInt();
	    long sum = 0;
	    for (int i = 0; i < m; i++)
	    {
		char [] c = bf.nextLine().toCharArray();
		for (int j = 0; j < c.length; j++)
		{
		    Integer tmp = map.get(c[j]);
		    if(tmp != null)
			sum += tmp;		    
		}
	    }
	    out.printf("%d.%02d$\n",sum/100,sum%100);
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