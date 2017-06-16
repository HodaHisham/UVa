
package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dividingcoins562 {

    static int [][] memo;
    static int [] coins;
    public static int min(int sum, int ind){
	if(ind == coins.length)
	    return Math.abs(sum-(coins.length>0?(coins[coins.length-1]-sum):0));
	if(memo[sum][ind] != -1)
	    return memo[sum][ind];
	return memo[sum][ind] = Math.min(min(sum,ind+1), min(sum+coins[ind]-(ind-1>=0?coins[ind-1]:0),ind+1));
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt();
	while(n-- > 0){
	    int m = bf.nextInt();
	    coins = new int[m];
	    for (int i = 0; i < m; i++){
		coins[i] = bf.nextInt();
		if(i > 0) coins[i] += coins[i-1];
	    }
	    memo = new int[50001][m+1];
	    for (int i = 0; i < memo.length; i++)
		Arrays.fill(memo[i], -1);
	    out.println(min(0,0));
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
