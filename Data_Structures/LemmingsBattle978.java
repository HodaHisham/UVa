package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LemmingsBattle978 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	while(n-->0 ){
	    st = new StringTokenizer(bf.readLine());
	    int B = Integer.parseInt(st.nextToken());
	    int SG = Integer.parseInt(st.nextToken());
	    int SB = Integer.parseInt(st.nextToken());
	    TreeMap<Integer,Integer> green = new TreeMap<Integer, Integer>();
	    TreeMap<Integer,Integer> blue = new TreeMap<Integer, Integer>();
	    for (int i = 0; i < SG; i++){
		int g = Integer.parseInt(new StringTokenizer(bf.readLine()).nextToken());
		green.put(g, green.get(g) == null? 1 : green.get(g)+1);
	    }
	    for (int i = 0; i < SB; i++){
		int b = Integer.parseInt(new StringTokenizer(bf.readLine()).nextToken());
		blue.put(b, blue.get(b) == null? 1 : blue.get(b)+1);
	    }
	    while(SG > 0 && SB > 0){
		int battles = B;
		if(SG < B || SB < B)
		    battles = Math.min(SB, SG);
		TreeMap<Integer,Integer> roundG = new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer> roundB = new TreeMap<Integer, Integer>();
		for (int i = 0; i < battles; i++)
		{
		    int powerG = green.lastKey();
		    int powerB = blue.lastKey();
		    int count = green.remove(powerG);
		    SG--;
		    if(count > 1)
			green.put(powerG, count -1);

		    count = blue.remove(powerB);
		    SB--;
		    if(count > 1)
			blue.put(powerB, count -1);
		    roundG.put(powerG, roundG.get(powerG) == null? 1 : roundG.get(powerG)+1);
		    roundB.put(powerB, roundB.get(powerB) == null? 1 : roundB.get(powerB)+1);
		}
		for (int i = 0; i < battles; i++){
		   int  powerG = roundG.lastKey();
		   int powerB = roundB.lastKey();
		    if(powerG > powerB){
			green.put(powerG - powerB, green.get(powerG - powerB) == null? 1 : green.get(powerG-powerB)+1);
			SG++;
		    }
		    else if(powerB > powerG){
			blue.put(powerB - powerG, blue.get(powerB - powerG) == null? 1 : blue.get(powerB-powerG)+1);
			SB++;
		    }
		    int count = roundG.remove(powerG);
		    if(count > 1)
			roundG.put(powerG, count -1);
		    count = roundB.remove(powerB);
		    if(count > 1)
			roundB.put(powerB, count -1);
		}
	    }
	    if(SB == 0 && SG == 0)
		out.println("green and blue died");
	    else if(SG == 0)
	    {
		out.println("blue wins");
		while(!blue.isEmpty()){
		    int last = blue.lastKey();
		    int count = blue.get(last);
		    for (int i = 0; i < count; i++)
			out.println(last);
		    //out.println(last + " " + count);
		    blue.remove(last);
		}
	    }
	    else {
		out.println("green wins");
		while(!green.isEmpty()){
		    int last = green.lastKey();
		    int count = green.get(last);
		    for (int i = 0; i < count; i++)
			out.println(last);
		    //out.println(last + " " + count);
		    green.remove(last);
		}
	    }
	   if(n>0) out.println();
	}
	out.flush();
	out.close();
    }
}
