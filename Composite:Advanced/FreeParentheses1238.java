package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FreeParentheses1238 {
    static int [] sign,num;
    static boolean memo[][][];
    static HashSet<Integer> set;
    public static void dp(int ind, int open, int val){
	if(ind == sign.length){
	    set.add(val);
	    return;
	}
	if(memo[ind][open][val+3000])
	    return;
	int tmp = val + (open % 2 == 0?1:-1)*sign[ind]*num[ind];
	if(open > 0)
	    dp(ind+1,open-1, tmp);
	if(sign[ind] == -1)
	    dp(ind+1,open+1,tmp);
	dp(ind+1, open, tmp);
	memo[ind][open][val+3000] = true;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    StringTokenizer s = new StringTokenizer(bf.nextLine());
	    int n = s.countTokens();
	    n = n/2+n%2;
	    sign = new int[n];
	    num = new int[n];
	    for (int i = 0; i < n; i++)
	    {
		sign[i] = i == 0?1:s.nextToken().charAt(0)=='+'?1:-1;
		num[i] = Integer.parseInt(s.nextToken());
	    }
	    memo = new boolean[n+1][n+1][6001];
	    set = new HashSet<Integer>();
	    dp(0,0,0);
	    int res = 0;
	    out.println(set.size());
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
	{ br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}
	
	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
	}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}

	public boolean ready() throws IOException {return br.ready();}

    }
}
