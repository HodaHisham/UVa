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


public class FactorsFactorials160 {
    public static void main(String[] args) throws IOException   {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	ArrayList<Integer> primes = new ArrayList<Integer>();
	boolean [] prime = new boolean[101];
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
	int factors [][]= new int[101][primes.size()];
	for (int i = 2; i < factors.length; i++)
	{
	    int tmp = i;
	    for (int j = 0; j < primes.size(); j++)
	    {
		int count = 0;
		int factor = primes.get(j);
		while(tmp % factor == 0){
		    count++;
		    tmp/=factor;
		}
		factors[i][j] = count; 
	    }
	}
	for (int i = 1; i < factors.length; i++)
	{
	    for (int j = 0; j < factors[i].length; j++)
	    {
		factors[i][j] += factors[i-1][j];
	    }

	}
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    out.printf("%3d! =",n);
	    int zeros = 0;
	    int num = 0;
	    for (int i = 0; i < primes.size() && primes.get(i) <= n; i++)
	    {
		if(num > 0 && num % 15 == 0)
		    out.print("\n      ");
		if(factors[n][i] > 0){
		    for (int j = 0; j < zeros; j++)
		    {
			out.printf("%3d",0);
		    }
		    num += zeros+1;
		    zeros = 0;
		    out.printf("%3d",factors[n][i]);
		}
		else zeros++;
	    }
	    out.println();
	}
	out.flush();
	out.close();
    }
    static class Pair{
	int num;
	int count;
	public Pair(int n , int c){
	    num = n;
	    count = c;
	}
	public String toString(){
	    return num + " " + count;
	}
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
