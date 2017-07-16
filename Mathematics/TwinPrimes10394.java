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


public class TwinPrimes10394 {

    static boolean prime [];
    static ArrayList<Integer>primes;
    static ArrayList<Pair> ans ;
    public static void sieve(int n){
	prime = new boolean[n+1];
	primes = new ArrayList<Integer>();
	ans = new ArrayList<Pair>();
	Arrays.fill(prime, true);
	prime[0] = prime[1] = false;
	for (int i = 2; i < prime.length; i++)
	{
	    if(prime[i]){
		if(i > 3 && primes.get(primes.size()-1) == i-2){
		    ans.add(new Pair(i-2, i));
		}
		primes.add(i);
		for (int j = i*2; j < prime.length; j+=i)
		{
		    prime[j] = false;
		}
	    }
	}
    }
    static class Pair{
	int x; int y;
	public Pair(int a, int b){
	    x = a;
	    y = b;
	}
	public String toString(){
	    return "("+x + ", " + y +")";
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve(20000000);
	while(bf.ready()){
	    int s = bf.nextInt();
	    out.println(ans.get(s-1));
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
