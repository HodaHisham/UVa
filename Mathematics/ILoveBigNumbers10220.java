package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ILoveBigNumbers10220 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int [] dig = new int[1001];
	BigInteger last = BigInteger.ONE;
	dig[0] = 1;
	for (int i = 1; i < dig.length; i++)
	{
	    char[] s = BigInteger.valueOf(i).multiply(last).toString().toCharArray();
	    for (int j = s.length-1; j >= 0; j--) dig[i] += s[j]-'0';
	    last = new BigInteger(new String(s));
	}
	while(bf.ready()){
	    //	while(true){
	    int n = bf.nextInt();
	    //	    if(n == -1) break;
	    out.println(dig[n]);
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
