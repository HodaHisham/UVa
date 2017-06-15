package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IDCodes146 {

    static boolean nextPermutation(char[] c) 
    {
	// 1. finds the largest k, that c[k] < c[k+1]
	int first = getFirst(c);
	if(first == -1)
	    return false;

	// 2. find last index toSwap, that c[k] < c[toSwap]
	int toSwap = c.length - 1;
	while (c[first] >= c[toSwap])
	    --toSwap;

	// 3. swap elements with indexes first and last
	swap(c, first++, toSwap);

	// 4. reverse sequence from k+1 to n (inclusive) 
	toSwap = c.length - 1;
	while(first < toSwap)
	    swap(c, first++, toSwap--);
	return true;
    }

    // finds the largest k, that c[k] < c[k+1]
    // if no such k exists (there is not greater permutation), return -1
    static int getFirst(char[] c) 
    {
	for ( int i = c.length - 2; i >= 0; i--)
	    if (c[i] < c[i + 1])
		return i;
	return -1;
    }


    static void swap(char[] c,int i, int j) 
    {
	char tmp = c[i];
	c[i] = c[j];
	c[j] = tmp;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    String tmp = bf.next();
	    if(tmp.equals("#"))
		break;
	    char [] c = tmp.toCharArray();
	    boolean b = nextPermutation(c);
	    if(b)
		out.println(c);
	    else out.println("No Successor");
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