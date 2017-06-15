package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Exhibition11348 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int k = Integer.parseInt(st.nextToken());
	for (int i = 1; i <= k; i++) 
	{
	    st = new StringTokenizer(bf.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    TreeSet <Integer> t = new TreeSet<Integer>();
	    TreeMap <Integer,Integer> map = new TreeMap<Integer,Integer>();
	    for (int j = 0; j < n; j++) 
	    {
		st = new StringTokenizer(bf.readLine());
		int m = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()){
		    int num = Integer.parseInt(st.nextToken());
		    if(!t.contains(num) && map.get(num) == null)
		    {
			t.add(num);
			map.put(num, j);
		    }
		    else 
			if(map.get(num) != j && map.get(num) != -1)
			{
			    map.put(num, -1);
			    t.remove(num);
			}

		}
	    }
	    int x = t.size();
	    if(x == 0)
	    {
		out.printf("Case %d:\n",i);
		continue;
	    }
	    TreeMap<Integer,Integer> h = new TreeMap<Integer,Integer>();
	    for(Iterator<Integer> i1= t.iterator();i1.hasNext();)
	    {
		int stamp = i1.next();
		int owner = map.get(stamp);
		if(owner == -1) 
		    continue;
		//out.println(stamp + " " + owner);
		if(h.containsKey(owner))
		    h.put(owner, h.get(owner)+1);
		else
		    h.put(owner, 1);
	    }
	    for (int j = 0; j < n; j++)
	    {
		if(!h.containsKey(j))
		    h.put(j, 0);
	    }

	    out.printf("Case %d:",i);
	    for(Iterator<Integer> i1= h.keySet().iterator();i1.hasNext();)
	    {
		int owner = i1.next();
		int value = h.get(owner);
		out.printf(" %.6f", ((double) (value) * 100 / x));
		out.print("%");
	    }
	    out.println();
	}
	out.flush();
	out.close();
    }
}
