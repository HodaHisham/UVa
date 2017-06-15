package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArmyBuddies12356 {

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    int s = bf.nextInt(), b = bf.nextInt();
	    if(s == 0 &&  b == 0)
		break;
	    int [] left = new int[s];
	    int [] right = new int[s];
	    for (int i = 0; i < right.length; i++)
	    {
		left[i] = i-1;
		right[i] = i+1;
	    }
	    for (int i = 0; i < b; i++)
	    {
		int l = bf.nextInt()-1, r = bf.nextInt()-1;
		if(left[l] > -1){
		    right[left[l]] = right[r];
		}
		if(right[r] < s){
		    left[right[r]] = left[l];
		}
		if(left[l] == -1)
		    out.print("*");
		else
		    out.print(left[l]+1);
		if(right[r] == s)
		    out.println(" *");
		else out.println(" "+(right[r]+1));
//		out.println(Arrays.toString(left));
//		out.println(Arrays.toString(right));
	    }
	    out.println("-");
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