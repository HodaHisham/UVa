package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ContestScoreboard10258 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	bf.nextLine();
	while(TC-- > 0)
	{
	    Con [] c = new Con[100];
	    for (int i = 0; i < c.length; i++)
	    {
		c[i] = new Con(i);
	    }
	    while(true){
		String tmp = bf.nextLine();
		if(tmp == null || tmp.isEmpty())
		    break;
		else bf.st = new StringTokenizer(tmp);
		int n = bf.nextInt()-1, prob = bf.nextInt()-1, t = bf.nextInt(); char ch = bf.next().charAt(0);
		c[n].vis = true;
		if(ch == 'C'){
		    if(c[n].arr[prob] == -1)
			continue;
		    c[n].p++;
		    c[n].pen += c[n].arr[prob] + t;
		    c[n].arr[prob] = -1;
		}
		else if(ch == 'I'){
		    if(c[n].arr[prob] == -1)
			continue;
		    c[n].arr[prob] += 20;
		}
	    }
	    Arrays.sort(c);
	    for(Con f:c)
		out.print(f);
	    if(TC > 0)
		out.println();
	}
	out.flush();
	out.close();
    }
    static class Con implements Comparable<Con>{
	int num, pen, p, arr[];
	boolean vis;
	public Con(int ind){
	    num = ind; pen = 0; p = 0;
	    arr = new int[9];
	}
	@Override
	public int compareTo(Con o)
	{
	    if(o.p == p){
		if(o.pen == pen)
		    return num - o.num;
		return pen - o.pen;
	    }
	    return o.p - p;
	}
	public String toString(){
	    return vis?num+1 + " " + p + " " + pen + "\n":"";
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