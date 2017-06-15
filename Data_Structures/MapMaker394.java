package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MapMaker394 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	String s = bf.readLine();
	while(s.isEmpty())
	    s = bf.readLine();
	StringTokenizer st = new StringTokenizer(s);
	int n = Integer.parseInt(st.nextToken());
	int r = Integer.parseInt(st.nextToken());
	TreeMap<String, int[] > arrays = new TreeMap<String, int[]>();
	while(n-->0){
	    s = bf.readLine();
	    while(s.isEmpty())
		s = bf.readLine();
	    st = new StringTokenizer(s);
	    String name = st.nextToken();
	    if(name.length() > 10)
		continue;
	    int b = Integer.parseInt(st.nextToken());
	    int cd = Integer.parseInt(st.nextToken());
	    int D = Integer.parseInt(st.nextToken());
	    int [] c = new int[D+1];
	    int [] l = new int[D+1];
	    int [] u = new int[D+1];
	    for (int i = 1; i <= D; i++)
	    {
		l[i] = Integer.parseInt(st.nextToken());
		u[i] = Integer.parseInt(st.nextToken());
	    }
	    c[D] = cd;
	    c[0] = b - (cd * l[D]);
	    for (int i = D-1; i > 0 ; i--)
	    {
		c[i] = c[i+1] * (u[i+1] - l[i+1] + 1);
		c[0] -= (c[i] * l[i]);
	    }
	    arrays.put(name, c);
	}
	while(r-->0){
	    s = bf.readLine();
	    while(s.isEmpty())
		s = bf.readLine();
	    st = new StringTokenizer(s);
	    String name = st.nextToken();
	    if(name.length() > 10)
		continue;
	    if(arrays.get(name) == null)
		continue;
	    int [] tmp = new int[arrays.get(name).length];
	    for (int i = 0; i < tmp.length; i++)
		tmp[i] = arrays.get(name)[i];
	    int [] i = new int[tmp.length];
	    for (int j = 1; j < i.length; j++)
		i[j] = Integer.parseInt(st.nextToken());
	    int address = tmp[0];   //calculating address
	    for (int j = 1; j < i.length; j++)
		address += (i[j] * tmp[j]); 
	    out.print(name + "[" ); //printing
	    for (int j = 1; j < i.length-1; j++)
		out.print(i[j] + ", ");
	    out.println(i[i.length-1] + "] = " + address);
	}	

	out.flush();
	out.close();
    }
}
