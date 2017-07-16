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

public class Divisors294 {
    static ArrayList<Integer> primes;
    static long numDiv(int N)
    {
	int PF_idx = 0, PF = primes.get(PF_idx); long ans = 1; // start from ans = 1 
	while (PF * PF <= N) {
	    long power = 0; // count the power 
	    while (N % PF == 0) { N /= PF; power++; }
	    ans *= (power + 1);
	    PF = primes.get(++PF_idx); 
	}
	if (N != 1) ans *= 2;
	return ans; 
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	primes = new ArrayList<Integer>();
	boolean [] prime = new boolean[100001];
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
	int n = bf.nextInt();
	while(n-->0){
	    int l = bf.nextInt(), r = bf.nextInt();
	    long ans = 0, div = 0;
	    for (int i = l; i <= r; i++)
	    {
		long tmp = numDiv(i);
		if(tmp > div){
		    div = tmp;
		    ans = i;
		}
	    }
	    out.printf("Between %d and %d, %d has a maximum of %d divisors.\n",l,r,ans,div);
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
