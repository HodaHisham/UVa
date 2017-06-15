package PSParadigms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Genes939 {
	public static final String exist = "non-existent";
	public static final String recess = "recessive";
	public static final String domin = "dominant";
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		TreeMap <String, Pair> t = new TreeMap<String,Pair>();
		while(n-->0 ){
			st = new StringTokenizer(bf.readLine());
			String first = st.nextToken();
			String second = st.nextToken();
			if(second.equals(exist)|| second.equals(recess)|| second.equals(domin))
				t.put(first, new Pair(1,second));
			else
				if(t.containsKey(second))
					t.get(second).parent2 = first;
				else
					t.put(second, new Pair(2,first));
		}
		boolean notFinished = true;
		while(notFinished){
			notFinished = false;
			for(Iterator i = t.keySet().iterator();i.hasNext();){
				String t1= (String)i.next();
				Pair p = t.get(t1);
				if(p.gene==null){

					String g1= t.get(p.parent1).gene;
					String g2  = t.get(p.parent2).gene;
					if(g1 != null && g2 != null){
						if((!g1.equals(exist)&&!g2.equals(exist))|| g1.equals(domin)|| g2.equals(domin)){ // existent
							if((g1.equals(domin)&& g2.equals(domin))|| (g1.equals(domin) && g2.equals(recess)) || (g2.equals(domin) && g1.equals(recess)))// dominant
								p.gene = domin;
							else //recessive
								p.gene = recess;
						}
						else //not-existent
							p.gene= exist;
					}
					else notFinished = true;
				}
			}
		}
		for(Iterator i = t.keySet().iterator();i.hasNext();){
			String t1= (String)i.next();
			Pair p = t.get(t1);
			out.println(t1 + " "+ p.gene);
		}
		out.flush();
		out.close();
	}
	static class Pair{
		String gene;
		String parent1;
		String parent2;
		public Pair(int i, String s){
			switch(i){
			case 1:
			{
				gene = s;
				break;
			}
			case 2:
			{
				parent1 = s;
				break;
			}
			}

		}
	}
}
