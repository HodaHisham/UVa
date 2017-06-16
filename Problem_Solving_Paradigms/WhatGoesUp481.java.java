package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class WavioSequence10534 {
    static int n,a[] ;
    public static int lis(){

	ArrayList<Integer> arr = new ArrayList<>();
	int [] l = new int[n], r = new int[n];
	for (int i = 0; i < n; i++)
	{
	    int idx = Collections.binarySearch(arr, a[i]);
	    if(idx < 0) idx = -(idx+1);
	    if(idx == arr.size())
		arr.add(a[i]);
	    else arr.set(idx, a[i]);
	    l[i] = idx;
	}
	arr = new ArrayList<>();
	for(int i = n-1; i >= 0; i--){
	    int idx = Collections.binarySearch(arr, a[i]);
	    if(idx < 0) idx = -(idx+1);
	    if(idx == arr.size())
		arr.add(a[i]);
	    else arr.set(idx, a[i]);
	    r[i] = idx;
	}
	int res = 0;
	for (int i = 0; i < n; i++)
	{
	    res = Math.max(res, 1 + 2*Math.min(l[i], r[i]));
	}
	return res;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    n = bf.nextInt();
	    a = new int[n];
	    for (int i = 0; i < a.length; i++)
	    {
		a[i] = bf.nextInt();
	    }
	    out.println(lis());
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