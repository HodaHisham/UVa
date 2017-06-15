package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P755 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	while(TC-->0){
	    int [] occ = new int[(int)1e8];
	    int n = bf.nextInt();
	    while(n-->0){
		int num = 0;
		char [] c = bf.next().toCharArray();
		for (int i = 0; i < c.length; i++)
		{
		    if(c[i] == '-')
			continue;
		    num *= 10;
		    int dig = 0;
		    if(c[i] >= '0' && c[i] <= '9')
			dig = c[i]-'0';
		    else
			switch(c[i])
			{
			    case 'A': case 'B': case 'C': 
				dig = 2;
				break;
			    case 'D': case 'E': case 'F':
				dig = 3;
				break;
			    case 'G': case 'H': case 'I': 
				dig = 4;
				break;
			    case'J': case 'K': case 'L':
				dig = 5;
				break;
			    case 'M': case 'N': case 'O': 
				dig = 6;
				break;
			    case 'P': case 'R':  case 'S':
				dig = 7;
				break;
			    case 'T': case 'U': case 'V': 
				dig = 8;
				break;
			    case 'W': case 'X': case 'Y':
				dig = 9;
				break;
			}
		    num += dig;
		}
		occ[num]++;
	    }
	    boolean flag = false;
	    for (int i = 0; i < occ.length; i++)
	    {
		if(occ[i] > 1){
		    out.printf("%03d-%04d %d\n",i/10000,(i%10000) ,occ[i]);
		    flag = true;
		}
	    }
	    if(!flag)
		out.println("No duplicates.");
	    if(TC > 0)
		out.println();
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