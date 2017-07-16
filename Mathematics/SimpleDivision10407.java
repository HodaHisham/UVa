package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SimpleDivision10407 {

    static int gcd(int a, int b){
	return b==0?a:gcd(b,a%b);
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    ArrayList<Integer> arr = new ArrayList<Integer>();	    
	    while(true){
		int s = bf.nextInt();
		if(s == 0)
		    break;
		arr.add(s-n);
	    }
	    int ans = arr.size() < 2?arr.get(0):gcd(arr.get(0),arr.get(1));
	    for (int i = 2; i < arr.size(); i++)
	    {
		ans = gcd(ans,gcd(arr.get(i),arr.get(i-1)));
	    }
	    out.println(Math.abs(ans));
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
