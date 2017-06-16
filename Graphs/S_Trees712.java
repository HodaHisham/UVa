package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_Trees712 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int k = 1;
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    StringTokenizer st = new StringTokenizer(bf.nextLine());
	    int [] val = new int[n];
	    int c = 0;
	    while(st.hasMoreTokens()){
		val[c++] = Integer.parseInt(st.nextToken().substring(1))-1;
	    }
	    char [] val2 = bf.next().toCharArray();
	    out.println("S-Tree #"+k+++":");
	    int m = bf.nextInt();
	    for (int i = 0; i < m; i++)
	    {
		char [] tmp = bf.next().toCharArray();
		int idx = 0, b = 0, e = (1<<n)-1;
		while(true){
		    if(idx == val.length)
		    {
			out.print(val2[b]);
			break;
		    }
		    if(tmp[val[idx]] == '0')
			e = b + (e-b)/2;
		    else b = e - (e-b)/2;
		    idx++;
		}
	    }
	    out.println();
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