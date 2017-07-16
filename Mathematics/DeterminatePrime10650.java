package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class DeterminatePrime10650 {
    static boolean prime [];
    static ArrayList<Integer>primes;
    public static void sieve(int n){
	prime = new boolean[n+1];
	primes = new ArrayList<Integer>();
	Arrays.fill(prime, true);
	prime[0] = prime[1] = false;
	for (int i = 2; i < prime.length; i++)
	{
	    if(prime[i]){
		primes.add(i);
		for (int j = 2*i; j < prime.length; j+=i)
		{
		    prime[j] = false;
		}
	    }
	}
    }
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve(32000);
	int[]len = new int[primes.size()];
	for (int i = 1; i < len.length; i++)
	{
	    len[i-1] = primes.get(i) - primes.get(i-1);
	}
	int t = 1;
	ArrayList<ArrayList<Integer>> sb = new ArrayList<ArrayList<Integer>>();
	for (int i = 0; i < len.length; i++)
	{
	    ArrayList<Integer> tmp = new ArrayList<Integer>();
	    t = 1;
	    while(i+1 < len.length && len[i] == len[i+1]){
		if(t++ == 1){
		    tmp.add(primes.get(i));
		    tmp.add(primes.get(i+1));
		    tmp.add(primes.get(i+2));
		}
		else{
		    tmp.add(primes.get(i+2));
		}
		i++;
	    }
//	    out.println(i + " " + tmp.toString());
	    if(tmp.size() > 1)
		sb.add(tmp);
	}
	while(true)
	{
	    int x = bf.nextInt();
	    int y = bf.nextInt();
	    if(x == 0 && y == 0)
		break;
	    if(y < x){
		x^=y;
		y^=x;
		x^=y;
	    }
	    int i = 0;
	    for( ;i < sb.size() && sb.get(i).get(0) < x;i++);
	    while(i < sb.size() && sb.get(i).get(0) >= x && sb.get(i).get(sb.get(i).size()-1)<= y){
		out.print(sb.get(i).get(0));
		for (int j = 1; j < sb.get(i).size(); j++)
		{
		    out.print(" "+sb.get(i).get(j));
		}
		out.println();
		i++;
	    }

	}
	out.flush();
	out.close();
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{    br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if(x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for(int i = start; i < x.length(); i++)
		if(x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		}
		else
		{
		    sb.append(x.charAt(i));
		    if(dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg?-1:1);
	}

	public boolean ready() throws IOException {return br.ready();}
    }
}
