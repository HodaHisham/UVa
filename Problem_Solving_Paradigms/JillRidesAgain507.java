package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class JillRidesAgain507 {

    public static void main(String[] args) throws Exception {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int t = bf.nextInt();
	for (int i = 1; i <= t; i++)
	{
	    int s = bf.nextInt();
	    int [] road = new int[s-1];
	    for (int j = 0; j < road.length; j++)
	    {
		road[j] = bf.nextInt();
	    }
	    Ans sum = new Ans(0,0,0);
	    Ans max = new Ans(0,0,0);
	    for (int j = 0; j < road.length; j++)
	    {
		sum = new Ans(sum.val+road[j], sum.x, j+1);
                if(sum.compareTo(max) > 0){
                    max = new Ans(sum.val,sum.x,sum.y);
                }
		if(sum.val < 0){
		   sum = new Ans(0, j+1, j+1);
		}
	    }
	    if(max.val == 0)
		out.printf("Route %d has no nice parts\n",i);
	    else
		out.printf("The nicest part of route %d is between stops %d and %d\n",i,max.x+1,max.y+1);
	}
	out.flush();
	out.close();
    }
    static class Ans implements Comparable<Ans>{
	int val;
	int x; 
	int y;
	public Ans(int val, int x, int y){
	    this.val = val;
	    this.x = x;
	    this.y = y;
	}
	public int compareTo(Ans o)
	{
	    if(val == o.val){
		if(y-x == o.y-o.x)
		    return o.x - x;
		else return y-x - (o.y - o.x);
	    }
	    else return val - o.val;
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
