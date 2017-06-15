package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MattyBlocks434 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	while(n-->0 ){
	    st = new StringTokenizer(bf.readLine());
	    int k = Integer.parseInt(st.nextToken());
	    ArrayList<Integer>front = new ArrayList<Integer>(k);
	    ArrayList<Integer>side = new ArrayList<Integer>(k);
	    int [][]top = new int[k][k];
	    st = new StringTokenizer(bf.readLine());
	    StringTokenizer s2 = new StringTokenizer(bf.readLine());
	    HashMap<Integer, ArrayList<Integer>> fMap = new HashMap<Integer, ArrayList<Integer>>();
	    HashMap<Integer, ArrayList<Integer>> sMap = new HashMap<Integer, ArrayList<Integer>>();
	    for (int i = 0; i < k; i++)
	    {
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(s2.nextToken());
		front.add(f);
		side.add(s);
		if(f!= 0){
		    if(fMap.containsKey(f))
			fMap.get(f).add(i);
		    else {
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(i);
			fMap.put(f, a);
		    }
		}
		if(s!=0){
		    if(sMap.containsKey(s))
			sMap.get(s).add(i);
		    else {
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(i);
			sMap.put(s, a);
		    }
		}
	    }
	    int min = 0;
	    int extra = 0;
	    for (int i = 1; i <= 8; i++) //adding common blocks in both views
	    {
		ArrayList<Integer> one= fMap.get(i);
		ArrayList<Integer> two= sMap.get(i);
		if(one == null || two == null)
		    continue;
		for (int j = 0,k1=0; ; j++,k1++)
		{
		    top[one.get(j)][two.get(k1)] = i;
		    min += i;
		    if(j==one.size()-1 && k1==two.size()-1)
			break;
		    else if(j==one.size()-1) 
			j--;

		    else if(k1==two.size()-1)
			k1--;
		}
		fMap.remove(i);
		sMap.remove(i);
	    }
	    for (int i = 0; i < k; i++) //adding blocks unique in front only
	    {
		if(!fMap.containsKey(front.get(i)))
		    continue;
		int j = 0;
		while(true){
		    if(j<k  && side.get(j) >= front.get(i) && top[i][j] == 0)
			break;
		    else
			j++;
		}
		//System.out.println(front.get(i) + " " + i);
		top[i][j] = side.get(j);
		min += front.get(i);
	    }
	    for (int i = 0; i < k; i++) //adding blocks unique in side only
	    {
		if(!sMap.containsKey(side.get(i))) 
		    continue;
		int j = 0;
		while(true){
		    if(j<k && front.get(j) >= side.get(i) && top[j][i] == 0 )
			break;
		    else
			j++;
		}
		top[j][i] = front.get(j);
		min += side.get(i);
	    }
	    //done with min blocks
	    for (int i = 0; i < k; i++){ //filling empty cells with possible extra blocks
		if(front.get(i) == 0)
		    continue;
		for (int j = 0; j < k; j++)
		{
		    if(top[i][j] == 0){
			top[i][j] = Math.min(front.get(i), side.get(j) );
			extra += top[i][j];
			//out.println(i + " " + j + " "+ top[i][j]);
		    }
		}

	    }


	    //done with extra blocks 
	    out.println("Matty needs at least " + min +" blocks, and can add at most " + extra + " extra blocks.");
	}
	out.flush();
	out.close();
    }
}
