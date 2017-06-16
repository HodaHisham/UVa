package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TheFallingLeaves699 {
    static ArrayList<Integer> s;
    static TreeMap<Integer,Integer> map;
    public static int fn(int val, int ind){
	if(ind == s.size())
	    return -1;
	if(s.get(ind) == -1)
	    return ind+1;
	int num = fn(val-1,ind+1); //left
        if(num != -1)
            num = fn(val+1,num); // right
        Integer b = map.get(val);
        if(b == null)
            b = 0;
        map.put(val, b+s.get(ind));
	return num;
    }
    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int cases = 1;
	while(true){
	    map = new TreeMap<Integer,Integer>();
	    int n = bf.nextInt();
	    if(n==-1)
		break;
	    int count = 2;
	    s = new ArrayList<Integer>();
	    s.add(n);
	    while(count > 0){
		int m = bf.nextInt();
		s.add(m);
		count--;
		if(m != -1)
		    count+=2;
	    }
	    fn(0,0);
	    out.printf("Case %d:\n",cases++);
	    StringBuilder sb = new StringBuilder();
	    while(!map.isEmpty())
	    {
		int fir = map.firstKey();
		sb.append(map.get(fir) +" ");
		map.remove(fir);
	    }
	    out.println(sb.length() == 0 ?"":sb.substring(0,sb.length()-1)+"\n");
	}
	out.flush();
	out.close();
    }
    static class Edge{
	int v; int cost;
	public Edge(int v, int cost){
	    this.v = v;
	    this.cost = cost;
	}
    }
    static class Scanner 
    {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public Scanner(FileReader fileReader)
	{    br = new BufferedReader(fileReader);	}

	public String next() throws IOException 
	{
	    while (st == null || !st.hasMoreTokens()) 
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}

	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
    }
}
