package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class StrategicDefenseInitiative497 {

    static Stack<Integer> stack;	//contains the last solution in increasing order

    static int lis(ArrayList<Integer> A, int n)		// Can be implemented with TreeSet (lower, remove, add)
    {
	ArrayList<Integer> L = new ArrayList<Integer>(); 
	int[] P = new int[n];			
	int[] L_id = new int[n];

	int lis = 0, lis_end = -1;
	for(int i = 0; i < n; ++i) 
	{
	    int pos = Collections.binarySearch(L, A.get(i));
	    if (pos < 0) pos = -(pos + 1);
	    //			 else	pos++;		non-decreasing

	    if(pos >= L.size()) L.add(A.get(i));
	    else                 L.set(pos, A.get(i));

	    if(pos + 1 > lis)
	    {
		lis = pos + 1;
		lis_end = i;
	    }

	    //lis_end and the following part for printing the solution
	    L_id[pos] = i;
	    P[i] = pos > 0 ? L_id[pos-1] : -1;
	}

	stack = new Stack<Integer>();
	while(lis_end != -1)
	{
	    stack.push(A.get(lis_end));
	    lis_end = P[lis_end];
	}
	return lis;
    }

    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int TC = bf.nextInt();
	bf.nextLine();
	while(TC-->0){
	    ArrayList<Integer> inp = new ArrayList<Integer>();
	    while(!bf.nxtEmpty()){
		inp.add(bf.nextInt());
	    }
	    stack = new Stack<Integer>();
	    out.println("Max hits: "+lis(inp,inp.size()));
	    while(!stack.isEmpty())
		out.println(stack.pop());
	    if(TC != 0) out.println();
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
	public boolean nxtEmpty() throws IOException
	{
	    String line = br.readLine();
	    if(line == null || line.isEmpty())
		return true;
	    st = new StringTokenizer(line);
	    return false;
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
