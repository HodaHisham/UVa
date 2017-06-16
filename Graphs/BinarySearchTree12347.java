package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BinarySearchTree12347 {
    static class Node{
	int val;
	Node r,l;
	public Node(int v){
	    val = v;
	}
    }
    static ArrayList<Integer> ans;
    static Node root;
    static void add(int val){
	Node cur = root;
	while(true){
	    if(val > cur.val)
		if(cur.r == null){
		    cur.r = new Node(val);
		    break;
		}
		else cur = cur.r;
	    else if(val < cur.val)
		if(cur.l == null){
		    cur.l = new Node(val);
		    break;
		}
		else cur = cur.l;  
	}
    }
    static void print(Node cur){
	if(cur == null)
	    return;
	print(cur.l);
	print(cur.r);
	ans.add(cur.val);
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	root = null;
	while(bf.ready()){
	    int t = bf.nextInt();
	    if(root == null)
		root = new Node(t);
	    else add(t);
	}
	ans = new ArrayList<>();
	print(root);
	for(int i:ans)
	    out.println(i);
	out.flush();
	out.close();
    }

    static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s)
	{
	    br = new BufferedReader(new InputStreamReader(s));
	}

	public Scanner(FileReader fileReader)
	{
	    br = new BufferedReader(fileReader);
	}

	public String next() throws IOException
	{
	    while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}

	public String nextLine() throws IOException
	{
	    return br.readLine();
	}

	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}