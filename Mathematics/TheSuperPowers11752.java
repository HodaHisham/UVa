package Math;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TheSuperPowers11752 {
    static ArrayList<Integer> primes;
    static TreeSet<Integer> notprimes;
    static int[] isComposite;

    static void sieve(int N)	// O(N log log N) 
    {
	isComposite = new int[N+1];					
	isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
	primes = new ArrayList<Integer>();
	notprimes = new TreeSet<Integer>();
	notprimes.add(0);
	for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
	    if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
	    {
		primes.add(i);
		if(1l * i * i <= N)
		    for (int j = i * i; j <= N; j += i){	// j = i * 2 will not affect performance too much, may alter in modified sieve
			isComposite[j] = 1;
			notprimes.add(j);
		    }
	    }   
    }
    static BigInteger c;
    public static void main(String[] args) throws Exception
    {
	PrintWriter out = new PrintWriter(System.out);
	sieve(64);
	StringBuilder s = new StringBuilder();
	for (int i = 0; i < 64; i++)
	{
	    s.append(1);
	}
	c = new BigInteger(s.toString(),2);
	TreeSet<BigInteger> set = new TreeSet<BigInteger>();
	for (int i = 2; i <= 65536; i++)
	{
	    for (int j:notprimes)
	    {
		BigInteger tmp = BigInteger.valueOf(i).pow(j);
		if(tmp.compareTo(c)< 0)
		    set.add(tmp);
		else break;
	    }
	}
	for(Iterator<BigInteger> i = set.iterator();i.hasNext();){
	    out.println(i.next());
	}
	out.flush();
	out.close();
    }
}
