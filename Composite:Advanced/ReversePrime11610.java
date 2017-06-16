package Misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class ReversePrime11610 {
    static ArrayList<Integer> primes;
    static int[] isComposite;
    static TreeSet<Integer> arr;
    static void sieve(int N)
    {
	isComposite = new int[N+1];					
	isComposite[0] = isComposite[1] = 1;	
	primes = new ArrayList<Integer>();
	arr = new TreeSet<Integer>();
	for (int i = 2; i <= N; ++i) 					
	    if (isComposite[i] == 0) 					
	    {
		primes.add(i);
		StringBuilder sb = new StringBuilder(""+i).reverse();
		while(sb.length() < 7)
		    sb.append("0");
		int num = Integer.parseInt(sb.toString());
		arr.add(num);
		if(1l * i * i <= N)
		    for (int j = i * i; j <= N; j += i)	
			isComposite[j] = 1;
	    }   
    }
    static int isPrime(int N)
    {
	int num = 0;
	for(int p: primes){	
	    while(N % p == 0){
		num++;
		N/=p;
	    }
	    if(p * p > N)
		break;
	}
	if(N > 1)
	    num++;
	return num;
    }
    static class FenwickTree { // one-based DS

	int n;
	int[] ft;

	FenwickTree(int size) { n = size; ft = new int[n+1]; }

	int rsq(int b) //O(log n)
	{
	    int sum = 0;
	    while(b > 0) { sum += ft[b]; b -= b & -b;}		//min?
	    return sum;
	}

	int rsq(int a, int b) { return rsq(b) - rsq(a-1); }	

	void point_update(int k, int val)	//O(log n), update = increment
	{
	    while(k <= n) { ft[k] += val; k += k & -k; }		//min?
	}

	int point_query(int idx)	// c * O(log n), c < 1
	{
	    int sum = ft[idx];
	    if(idx > 0)
	    {
		int z = idx ^ (idx & -idx);
		--idx;
		while(idx != z)
		{
		    sum -= ft[idx];
		    idx ^= idx & -idx;
		}
	    }
	    return sum;
	}

	void scale(int c) {	for(int i = 1; i <= n; ++i)	ft[i] *= c;	}

	int findIndex(int cumFreq)
	{
	    int msk = n;
	    while((msk & (msk - 1)) != 0)
		msk ^= msk & -msk;			//msk will contain the MSB of n

	    int idx = 0;
	    while(msk != 0)
	    {
		int tIdx = idx + msk;
		if(tIdx <= n && cumFreq >= ft[tIdx])
		{
		    idx = tIdx;
		    cumFreq -= ft[tIdx];
		}
		msk >>= 1;
	    }
	    if(cumFreq != 0)
		return -1;
	    return idx;
	}
    }

    public static void main(String[] args) throws Exception { //EOF change to !!
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	sieve(1000000);
	HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
	FenwickTree delete = new FenwickTree(arr.size());
	FenwickTree val = new FenwickTree(arr.size());
	int k = 1;
	for (int x:arr)
	{
	    val.point_update(k, isPrime(x));
	    delete.point_update(k, 1);
	    map.put(x, k++);
	}
	while(bf.ready()){
	    
	    char c = bf.next().charAt(0);
	    if(c == 'q'){
		int ind = delete.findIndex(bf.nextInt()+1);
		out.println(val.rsq(ind));
	    }
	    else{
		int ind = map.get(bf.nextInt());
		delete.point_update(ind, -1);
		val.point_update(ind, -val.point_query(ind));
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
	{   br = new BufferedReader(fileReader);	}

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
