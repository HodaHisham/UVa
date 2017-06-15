package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Containers1062 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String st = bf.readLine();
	int count = 1;
	while(!st.equals("end"))
	{
	    ArrayList<Stack> s = new ArrayList<Stack>();
            s.add(new Stack<Character>());
            s.get(0).push(st.charAt(0));
            for (int i = 1; i < st.length(); i++)
	    {
		char c = st.charAt(i);
		boolean isPushed = false;
		for (int j = 0; j < s.size() && !isPushed; j++)
		{
		    if((Character)s.get(j).peek() >= c){
			s.get(j).push(c);
			isPushed = true;
		    }
		}
		if(!isPushed){
		    s.add(new Stack<Character>());
		    s.get(s.size()-1).push(c);
		}
	    }
	    out.println("Case " + count++ + ": " + s.size());
	    st = bf.readLine();
	}
	out.flush();
	out.close();
    }
}
