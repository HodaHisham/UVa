package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TeamQueue540 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int t = Integer.parseInt(st.nextToken());
	int count = 1;
	while(t != 0 ){
	    ArrayList<Queue<Integer>> arr = new ArrayList<Queue<Integer>>(t);
	    //   for(int i = 0; i < t;i++)
	    //	arr.add(new LinkedList<Integer>());
	    TreeMap<Integer, Integer> playersToTeams = new TreeMap<Integer, Integer>();
	    TreeMap<Integer, Integer> teamsEnqueued = new TreeMap<Integer, Integer>();
	    for (int i = 0; i < t; i++)
	    {
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int j = 0; j < n; j++)
		    playersToTeams.put(Integer.parseInt(st.nextToken()), i);

	    }
	    int teamsRemoved = 0;
	    int teamsAdded = 0;
	    out.println("Scenario #" + count++);
	    st = new StringTokenizer(bf.readLine());
	    String s = st.nextToken();
	    while(!s.equals("STOP"))
	    {
		if(s.equals("ENQUEUE")){
		    int player = Integer.parseInt(st.nextToken());
		    int team = playersToTeams.get(player);
		    if(teamsEnqueued.get(team) == null)
		    {
			arr.add(new LinkedList<Integer>());
			teamsEnqueued.put(team, teamsAdded++);
			arr.get(arr.size()-1).add(player);
		    }
		    else
		    {
			arr.get(teamsEnqueued.get(team)-teamsRemoved).add(player);
		    }
		} 
		else if(s.equals("DEQUEUE")){
		    if(arr.isEmpty())
			continue;
                    int player = arr.get(0).poll();
                    int team = playersToTeams.get(player);
		    out.println(player);
		    if(arr.get(0).isEmpty()){
			teamsEnqueued.remove(team);
			arr.remove(0);
			teamsRemoved++;
		    }
		}
		st = new StringTokenizer(bf.readLine());
		s = st.nextToken();

	    }
	    out.println();
	    st = new StringTokenizer(bf.readLine());
	    t = Integer.parseInt(st.nextToken());
	}
	out.flush();
	out.close();
    }
}
