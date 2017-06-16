package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bridge10037 {


    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	StringBuilder res = new StringBuilder();
	while(TC-->0){
	    int n = bf.nextInt();
	    LinkedList<Integer> r = new LinkedList<>();
	    LinkedList<Integer> l = new LinkedList<>();
	    for (int i = 0; i < n; i++)
	    {
		l.add(bf.nextInt());
	    }
	    Collections.sort(l);
	    int sum = 0;
	    StringBuilder sb = new StringBuilder();
	    while(l.size() > 2){
		if(r.size() == 0){
		    int x = l.removeFirst(), y = l.removeFirst();
		    sb.append(x+" "+y+"\n"+x+"\n");
		    r.add(y); l.addFirst(x);
		    sum += x+y;
		}
		else{
		    int x = l.removeLast(), y = l.removeLast(), f = r.removeFirst(), a = l.removeFirst();
		    if(f*2 > a+y){
			l.add(y); l.add(x);
			int b = l.removeFirst();
			sb.append(a +" "+b+"\n"+a+"\n");
			sum += a + b;
			l.addFirst(a); r.add(b); r.add(f);
		    }
		    else{
			sum += f+x;
			sb.append(y+" "+x+"\n"+f+"\n");
			r.add(y); r.add(x); 
			l.addFirst(a);
			l.addFirst(f);
		    }
		}
		Collections.sort(r);
		Collections.sort(l);
	    }
	    if(l.size() == 1){
		int tmp = l.getFirst();
		sum += tmp;
		sb.append(tmp +"\n");
	    }
	    else if(l.size() == 2){
		int tmp = l.removeFirst();
		sb.append(tmp + " ");
		tmp = l.removeFirst();
		sum += tmp;
		sb.append(tmp + "\n");
	    }
	    if(TC > 0)
		sb.append("\n");
	    res.append(sum +"\n");
	    res.append(sb);
	}
	out.print(res);
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