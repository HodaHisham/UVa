package GEOM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AnEasyTask11068 {

    static int gcd(int a, int b)
    {
	return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	StringBuilder sb = new StringBuilder();
	while (true)
	{
	    int a = bf.nextInt(), b = bf.nextInt(), c = bf.nextInt();
	    int a2 = bf.nextInt(), b2 = bf.nextInt(), c2 = bf.nextInt();
	    if (a == 0 && b == 0 && c == 0 && a2 == 0 && b2 == 0 && c2 == 0)
		break;
	    int gcdA = gcd(a, b), gcdB = gcd(a2,b2);
	    if (b == 0 && b2 == 0 || a == 0 && b == 0 || a2 == 0 && b2 == 0 || b != 0 && b2 != 0 && a/gcdA == a2/gcdB && b/gcdA == b2/gcdB)
		sb.append("No fixed point exists.\n");
	    else
	    {
		double x = 1.0*(b*c2-b2*c)/(a2*b-a*b2);
		sb.append(String.format("The fixed point is at %.2f %.2f.\n", x, b != 0?(c-a*x)/b:(c2-a2*x)/b2));
	    }
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