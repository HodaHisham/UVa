package AdHocs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ASpecialHappyBirthdaySong12554 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	String [] s = new String [] {"Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"};
	String [] name = new String[n];
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < name.length; i++)
	{
	    name[i] = bf.next();
	}
	int idx = 0, ind = 0;
	while(idx < name.length)
	{
	    sb.append(name[idx++]).append(": ").append(s[ind++]).append("\n");
	    if(ind == s.length)
		ind = 0;
	}
	idx = 0;
	while(ind < s.length)
	{
	    sb.append(name[idx++]).append(": ").append(s[ind++]).append("\n");
	    if(idx == name.length) idx = 0;
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