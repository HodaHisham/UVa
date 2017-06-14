import java.io.*;
import java.util.*;
public class LanguageDetection {
 public static void main(String[]args)throws java.lang.Exception{
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    int i = 1;
    String lang;
    while(!s.equals("#")){
      	switch(s){
      		case "HELLO":{lang= "ENGLISH";break;}
      		case "BONJOUR":{lang= "FRENCH";break;}
      		case "CIAO":{lang= "ITALIAN";break;}
      		case "HOLA":{lang="SPANISH"; break;}
      		case "HALLO":{lang="GERMAN"; break;}
      		case "ZDRAVSTVUJTE":{lang= "RUSSIAN"; break;}
      		default: {lang= "UNKNOWN"; break;}
      	}


      System.out.println("Case " + (i++) +": " + lang);
      s = bf.readLine();
    }
 }
}