package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimeTime10200 {
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
	static boolean isPrime(int N)
	{
		if(N < isComposite.length)
			return isComposite[N] == 0;
		for(int p: primes)					//may stop if p * p > N
			if(N%p==0)
				return false;
		return true;
	}
    public static void main(String[] args) throws Exception {

	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve(100000);
        int [] sum = new int[10001];
        Arrays.fill(sum, 1);
        for (int i = 40; i < sum.length; i++)
	{
	    sum[i] = isPrime(i*(i+1)+41)?1:0;
	}
        for (int j = 1; j < sum.length; j++)
	{
	    sum[j] += sum[j-1];
	}
	while(bf.ready()){
	    int x = bf.nextInt(), y = bf.nextInt();
            out.printf("%.2f\n",(sum[y]-(x==0?0:sum[x-1]))*100.0/(y-x+1));
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
	{
	    br = new BufferedReader(fileReader);
	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}
    }
}
