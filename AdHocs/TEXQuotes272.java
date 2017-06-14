import java.io.*;
import java.util.*;
public class texquotes {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    String str;
    int k = 0;
    int j = 0 ;
    String out = "";
    while((str = bf.readLine())!= null){
    	k= 0;
    	out = "";
    	int i = str.indexOf("\"",k);
    	while(i != -1){

    	if((j & 1)==1){//odd
    	  out += str.substring(k,i+1).replace("\"", "\'\'");
    	}
    	else
    	   out += str.substring(k,i+1).replace("\"", "``");
    	k= i+1;
    	j++;
    	i = str.indexOf("\"",k);
    	}
        out += str.substring(k,str.length());
    	System.out.println(out);
    }

 }
}