package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordIndex417 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String s = bf.readLine();
	TreeMap<String,Integer> map = new TreeMap<String,Integer>();
	TreeSet< String> t = new TreeSet<String>(new Sorter());
	StringBuilder seq = new StringBuilder();
	for (int i = 1; i <= (65011712); i++) {
	    seq = new StringBuilder();
	    if(Integer.bitCount(i) > 5)
		continue;
	    for (int j = 0; (1<<j )<= i ; j++)
	    {
		if(((1<<j) & i)!= 0)
		    seq.append((char)('a'+j));
	    }
	    t.add(seq.toString());
	}
	int j = 1;
	for(Iterator<String> i = t.iterator(); i.hasNext();j++){
	    String str = i.next();
	    //out.println(str);
	    map.put(str, j);
	}
	while(s != null){
	    if(s.isEmpty()){
		s = bf.readLine();
		continue;
	    }
	    StringTokenizer st  = new StringTokenizer(s);
	    String str = st.nextToken();
	    out.println(map.get(str)!= null ? map.get(str):0);
	    s = bf.readLine();
	}
	out.flush();
	out.close();
    }
    static class Sorter implements Comparator<String>{

	@Override
	public int compare(String o1, String o2)
	{
	    // TODO Auto-generated method stub
	    if(o1.length() == o2.length())
		return o1.compareTo(o2);
	    else
		return o1.length() - o2.length();
	}

    }
}