package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ErrorCorrection541 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int n = bf.nextInt();
	    if(n == 0)
		break;
	    int [][] mat = new int[n][n];
	    int numR = 0, numC = 0, r = -1, c = -1;
	    for (int i = 0; i < n; i++)
	    {
		int sum = 0;
		for (int j = 0; j < n; j++)
		{
		    mat[i][j] = bf.nextInt();
		    sum += mat[i][j];
		}
		if((sum & 1) != 0){
		    numR++; r = i;
		}
	    }
	    for (int i = 0; i < n; i++)
	    {
		int sum = 0;
		for (int j = 0; j < n; j++)
		{
		    sum += mat[j][i];
		}
		if((sum & 1) != 0){
		    numC++; c = i;
		}
	    }
	    if(numR == 0 && numC == 0) out.println("OK");
	    else{
		if(numR == 1 && numC == 1)
		    out.printf("Change bit (%d,%d)\n",r+1,c+1);
		else out.println("Corrupt");
	    }
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