package PSParadigms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LargestSubmatrix836 {
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	bf.nextLine();
	while(TC-->0){
	    String s = bf.nextLine();
	    int n = s.length();
	    int [][] mat = new int[n][n];
	    for (int i = 0; i < n; i++) { 
		for (int j = 0; j < n; j++) {
		    mat[i][j] = s.charAt(j)-'0';
		    if (i > 0) mat[i][j] += mat[i - 1][j]; 
		    if (j > 0) mat[i][j] += mat[i][j - 1]; 
		    if (i > 0 && j > 0) mat[i][j] -= mat[i - 1][j - 1];
		}
		if(i < n-1) s = bf.nextLine();
	    }
	    int subRect = 0, maxSubRect = 0, ans = 0;
	    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) 
		for (int k = i; k < n; k++) for (int l = j; l < n; l++) { 
		    subRect = mat[k][l]; 
		    if (i > 0) subRect -= mat[i - 1][l];
		    if (j > 0) subRect -= mat[k][j - 1];
		    if (i > 0 && j > 0) subRect += mat[i - 1][j - 1]; 
		    if(subRect == (k-i+1)*(l-j+1)){
			maxSubRect = Math.max(maxSubRect, subRect);
		    }
		}
	    out.println(maxSubRect);
	    if(TC > 0)
		out.println();
	    bf.nextLine();
	}
	out.flush();
	out.close();
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public double nextDouble() throws IOException
	{
	    String x = next();
	    StringBuilder sb = new StringBuilder("0");
	    double res = 0, f = 1;
	    boolean dec = false, neg = false;
	    int start = 0;
	    if(x.charAt(0) == '-')
	    {
		neg = true;
		start++;
	    }
	    for(int i = start; i < x.length(); i++)
		if(x.charAt(i) == '.')
		{
		    res = Long.parseLong(sb.toString());
		    sb = new StringBuilder("0");
		    dec = true;
		}
		else
		{
		    sb.append(x.charAt(i));
		    if(dec)
			f *= 10;
		}
	    res += Long.parseLong(sb.toString()) / f;
	    return res * (neg?-1:1);
	}

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
