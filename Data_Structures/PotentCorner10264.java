package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PotentCorner10264 {
    public static void main(String[] args) throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String s = bf.readLine();
	while(s != null){
	    while(s.isEmpty())
		s = bf.readLine();
	    StringTokenizer st = new StringTokenizer(s);
	    int n = Integer.parseInt(st.nextToken());
	    int [] weights = new int[1<<n];
	    for (int i = 0; i < weights.length; i++){
		String str = bf.readLine();
		while(str.isEmpty())
		    str = bf.readLine();
		weights[i] = Integer.parseInt(new StringTokenizer(str).nextToken());

	    }
	    int [] potency = new int[1<<n];
	    for (int i = 0; i < potency.length; i++) //calculating potency based on the assumption that the neighboring corners differ with me in no. of ones by one
	    {
		for (int j = 0; j < n ; j++)
		{
		    potency[i] += weights[i^(1<<j)];

		}
	    }
	    int maxPot = 0;
	    for (int i = 0; i < potency.length-1; i++) // finding maxPotency
		for (int j = 0; j<n ; j++)
		    if((i^(1<<j))> i)
			maxPot = Math.max(potency[i] + potency[i^(1<<j)], maxPot);

	    out.println(maxPot);
	    s = bf.readLine();
	}
	out.flush();
	out.close();
    }
}
