package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FileFragmentation10132 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		bf.readLine();
		while(t-->0 ){
			
			String s = bf.readLine();
			int n = 0;
			int b= 0;
			ArrayList<String> arr= new ArrayList<String>();
			TreeMap<String,Integer > map = new TreeMap<String,Integer>();
			while(s!= null && !s.isEmpty()){
				n++;
				b+= s.length();
				arr.add(s);
				s= bf.readLine();
			}
			b = (b*2)/n;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i != j){
						String x =arr.get(i) ;
						String y= arr.get(j);
						if(x.length()+y.length()==b)
							if(map.containsKey(x+y))
								map.put(x+y, map.get(x+y)+1);
							else
								map.put(x+y, 1);
					}
				}
			}
			int max = 0;
			String maxString = "";
			for(Iterator<String> i = map.keySet().iterator();i.hasNext();){
				String str = i.next();
				int value = map.get(str);
				if(value>max){
					maxString = str;
					max = value;
				}
			}
			
			out.println(maxString);
			if(t>0) out.println();
		}
		out.flush();
		out.close();
	}
	
}
