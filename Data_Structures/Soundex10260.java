package DataStructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Soundex10260 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int [] hash = new int[26];
	for (char i = 'A'; i <= 'Z'; i++)
	{
	    switch(i){
		case 'B':
		case 'F':
		case 'P':
		case 'V':
		    hash[i-'A'] = 1;
		    break;
		case 'C': case 'G': case 'J':  case 'K': case 'Q': case 'S' : case 'X': case 'Z':
		    hash[i-'A'] = 2;
		    break;
		case 'D': case 'T':
		    hash[i-'A'] = 3;
		    break;
		case 'L':
		    hash[i-'A'] = 4;
		    break;
		case 'M' : case 'N': 
		    hash[i-'A'] = 5;
		    break;
		case 'R':
		    hash[i-'A'] = 6;
		    break;
	    }
	}
	while(bf.ready()){
	    char [] c = bf.next().toCharArray();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < c.length; i++)
	    {
		for(; i+1 < c.length && hash[c[i]-'A'] == hash[c[i+1]-'A'] ; i++);
		if(hash[c[i]-'A'] > 0)
		    sb.append(hash[c[i]-'A']);
	    }
	   out.println(sb);
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