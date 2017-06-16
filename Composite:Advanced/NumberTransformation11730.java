package Misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class NumberTransformation11730 {
    static ArrayList<Integer>[] factors;
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

    static ArrayList<Integer> primeFactors(int N)		
    {
	int tmp = N;
	ArrayList<Integer> factors = new ArrayList<Integer>();	
	int idx = 0, p = primes.get(idx);

	while(p * p <= N)
	{
	    if(N % p == 0) factors.add(p);
	    while(N % p == 0) {  N /= p; }
	    p = primes.get(++idx);
	}
	if(N != 1 && N != tmp)						
	    factors.add(N);				
	return factors;
    }
    static int s,t, memo[][];
    static int INF = (int) 1e9;
    public static int dp(int x, int y){
	if(x == y)
	    return memo[x][y] = 0;
	if(x > y || factors[x].size() == 0){
	    if(x <= 1001 && y <= 1001){
		memo[x][y] = INF;
	    }
	    return INF;
	}
	if(memo[x][y] != -1)
	    return memo[x][y];

	int ans = 1 + dp(x+factors[x].get(0),y);
	for (int i = 1; i < factors[x].size(); i++)
	{
	    if(x + factors[x].get(i) <= y)
		ans = Math.min(ans,1+dp(x + factors[x].get(i),y));
	    else
		break;
	}
	return memo[x][y] = ans;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve(1000);
	factors = new ArrayList[1001];
	for (int i = 1; i <= 1000; i++)
	{
	    factors[i] = primeFactors(i);
	}
	memo = new int[1001][1001];
	for (int i = 0; i < memo.length; i++)
	{
	    Arrays.fill(memo[i],-1);
	}
	int cases = 1;
	while(true){
	    s = bf.nextInt();
	    t = bf.nextInt();
	    if(s == 0 && t == 0)
		break;
//	    System.out.println(s +" "+t)
	    int ans = dp(s,t);
	    out.println("Case "+ cases++ + ": " + (ans>=INF?-1:ans));
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
    }
}
