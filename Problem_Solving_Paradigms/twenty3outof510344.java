package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class twenty3outof510344 {
    static int [] num;
    static boolean ans;
    public static void back(int sum, int ind, int mask){
	if(ind == 5)
	{
	    ans |= sum == 23;
	    return;
	}
	for (int i = 0; i < 5; i++)
	{
	    if((mask & (1<<i)) == 0){
		back(sum+num[i],ind+1,mask|(1<<i));
		back(sum-num[i],ind+1,mask|(1<<i));
		back(sum*num[i],ind+1,mask|(1<<i));
	    }
	}
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(true){
	    num = new int[5];
	    boolean flag = true;
	    for (int i = 0; i < num.length; i++)
	    {
		num[i] = bf.nextInt();
		if(num[i] != 0)
		    flag = false;
	    }
	    if(flag) break;
	    ans = false;
	    for (int i = 0; i < 5; i++)
	    {
		back(num[i],1,(1<<i));
	    }
	    out.println(ans?"Possible":"Impossible");
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