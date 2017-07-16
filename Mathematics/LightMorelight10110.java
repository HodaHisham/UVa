package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class LightMorelight10110 {
	//Accepted sol but 2.8 s, there is an observation which is the uncommented sol
	//    static ArrayList<Long> primes;
	//    static long numDiv(long N)
	//    {
	//	int PF_idx = 0; long PF = primes.get(PF_idx), ans = 1; // start from ans = 1 
	//	while (PF * PF <= N) {
	//	    long power = 0; // count the power 
	//	    while (N % PF == 0) { N /= PF; power++; }
	//	    ans *= (power + 1);
	//	    PF = primes.get(++PF_idx); 
	//	}
	//	if (N != 1) ans *= 2;
	//	return ans; 
	//    }
	//    static boolean isPrime(long N)
	//    {
	//	if(N < prime.length)
	//	    return prime[(int) N];
	//	for(Long p: primes)					//may stop if p * p > N
	//	    if(N%p==0)
	//		return false;
	//	return true;
	//    }
	//    static boolean [] prime;
	public static void main(String[] args) throws Exception
	{
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		//	primes = new ArrayList<Long>();
		//	prime = new boolean[(int)1e8];
		//	Arrays.fill(prime, true);
		//	prime[0] = prime[1] = false;
		//	for (int i = 2; i < prime.length; i++)
		//	{
		//	    if(prime[i]){
		//		primes.add((long) i);
		//		for (int j = 2*i; j < prime.length; j+=i)
		//		{
		//		    prime[j] = false;
		//		}
		//	    }
		//	}
		//	for (long i = (int)1e8+1; i <= (1<<32)-1; i++)
		//	{
		//	    if(isPrime(i))
		//		primes.add(i);
		//	}
		while(true){
			long n = bf.nextLong();
			if(n == 0)
				break;
			//	    out.println((numDiv(n)&1)==0?"no":"yes");
			long x = (long)Math.sqrt(n);
			out.println(x*x==n?"yes":"no");
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
