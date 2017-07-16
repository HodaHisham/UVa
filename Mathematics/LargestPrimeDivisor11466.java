package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LargestPrimeDivisor11466 {

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

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve((int)1e7);
	while(true){
	    long n = bf.nextLong();
	    if(n == 0) break;
	    n = Math.abs(n);
	    long ans = -1, num = 0;
	    for(int p: primes)
	    {
              if(1l*p*p <= n){
        	  if(n % p == 0){
        	      ans = p; num++;
        	  }
        	  while(n % p == 0)
        	  {
        	      n/=p;
        	  }
              }
	    }
	    if(n != 1 && ans != -1){
		ans = n; num++;
	    }
	    out.println(num > 1?ans:-1);
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
