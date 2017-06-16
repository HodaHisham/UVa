package PSParadigms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EcologicalBin102{ 

    public static void main(String[]args) throws IOException{
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int [][] a = new int[3][3];
	    for (int i = 0; i < a.length; i++)
		for (int j = 0; j < a.length; j++)
		    a[i][j] = bf.nextInt();
	    int ans = Integer.MAX_VALUE;
	    String res = "ZZZ";
	    for (int i = 0; i < 3; i++)
	    {
		for (int j = 0; j < 3; j++)
		{
		    if(i == j)
			continue;
		    for (int k = 0; k < 3; k++)
		    {
			if(k == i || k == j)
			    continue;
			int tmp = a[j][0]+a[k][0] + a[i][1]+a[k][1]+a[i][2]+a[j][2];
			String s = i == 0?j==1?"BGC":"BCG":i==1?j==0?"GBC":"CBG":j==0?"GCB":"CGB";
			if(tmp < ans || tmp == ans && res.compareTo(s) > 0){
			    ans = tmp;
			    res = s;
			}
		    }
		}
	    }
	    out.println(res + " " + ans);
	}
	out.flush();
	out.close();
    }
    static class Scanner{
	BufferedReader bf;
	StringTokenizer st;
	public Scanner(InputStream s){
	    bf = new BufferedReader(new InputStreamReader(s));
	}
	public Scanner(FileReader fileReader)
	{
	    bf = new BufferedReader(fileReader);
	}
	public String next() throws IOException{
	    while(st == null || !st.hasMoreTokens())
		st = new StringTokenizer(bf.readLine());
	    return st.nextToken();
	}
	public String nextLine() throws IOException{
	    return bf.readLine();
	}
	public int nextInt() throws NumberFormatException, IOException{
	    return Integer.parseInt(next());
	}
	public boolean ready() throws IOException{
	    return bf.ready();
	}
    }
}