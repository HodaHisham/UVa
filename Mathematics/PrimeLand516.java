package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrimeLand516 {

    static ArrayList<Integer> factors;
    /*
     * 1. Generating a list of prime factors of N
     */	
    static ArrayList<Integer> primeFactors(int N)		// O(sqrt(N) / ln sqrt(N))
    {
	factors = new ArrayList<Integer>();		//take abs(N) in case of -ve integers
	int idx = 0, p = primes.get(idx);

	while(p * p <= N)
	{
	    int e = 0;
	    if(N % p == 0) {
		factors.add(p);
		while(N % p == 0) { N /= p; e++;}
		factors.add(e);
	    }
	    p = primes.get(++idx);
	}

	if(N != 1){		
	    factors.add(N);	
	    factors.add(1);
	}
	return factors;
    }
    static ArrayList<Integer> primes;
    static int[] isComposite;

    static void sieve(int N)	// O(N log log N) 
    {
	isComposite = new int[N+1];					
	isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
	primes = new ArrayList<Integer>();

	for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
	    if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
	    {
		primes.add(i);
		if(1l * i * i <= N)
		    for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
			isComposite[j] = 1;
	    }   
    }
    static int pow(long a, int n)
    {
	int res = 1;
	while(n != 0)
	{
	    if((n & 1) == 1)
		res *= a;
	    a *= a;
	    n >>= 1;			
	}
	return res;
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve(32770);
	while(true){
	    StringTokenizer st = new StringTokenizer(bf.nextLine());
	    int i = Integer.parseInt(st.nextToken());
	    if(i == 0) break;
	    int num = pow(i,Integer.parseInt(st.nextToken()));
	    while(st.hasMoreTokens())
		num *= pow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	    primeFactors(num-1);
	    for (int j = factors.size()-2; j >= 0; j-=2)
	    {
		out.print(factors.get(j) + " " + factors.get(j+1));
		if(j > 0) out.print(" ");
	    }
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
