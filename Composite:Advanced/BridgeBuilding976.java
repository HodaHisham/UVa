package Misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BridgeBuilding976 {
    static int [][] memo,mat;
    static int[] north, south;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public static void dfs(int r, int c, boolean flag){ //flag is true if north
	mat[r][c] = flag?2:-2;
	for (int i = 0; i < dx.length; i++)
	{
	    if(isValid(r+dx[i], c+dy[i]))
		dfs(r+dx[i],c+dy[i],flag);
	}

    }
    public static boolean isValid(int r, int c){
	return r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == 1;
    }
    static int s;
    static int INF = (int)1e9;
    public static int dp(int ind, int b){
	if(b == 0)
	    return 0;
	//	if(memo[0].length - 1-ind < (1+s)*b)
	//	    return INF;
	if(ind >= mat[0].length)
	    return INF;
	if(memo[ind][b] != -1)
	    return memo[ind][b];
	int take = south[ind] - north[ind] + 1+ dp(ind+s+1,b-1);
	int leave = dp(ind+1,b);
	return memo[ind][b] = Math.min(take, leave);
    }
    public static void main(String[]args) throws IOException{ ///change to eof
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	while(bf.ready()){
	    int r = bf.nextInt();
	    int c = bf.nextInt();
	    int b = bf.nextInt();
	    s = bf.nextInt();
	    mat = new int[r][c];
	    memo = new int[c+1][b+1];
	    for (int i = 0; i < memo.length; i++)
	    {
		Arrays.fill(memo[i],-1);
	    }
	    north = new int[c];
	    south = new int[c];
	    for(int i = 0 ; i < r;i++){
		String st = bf.nextLine();
		for(int j = 0 ; j < c; j++){
		    mat[i][j] = st.charAt(j)=='#'?1:0;
		}
	    }
	    dfs(0,0,true);
	    dfs(r-1,0,false);
	    for (int i = 0; i < c; i++)
	    {
		for (int j = 0; j < r; j++)
		{
		    if(mat[j][i] == 2)
			north[i] = j+1;
		    if(mat[j][i] == -2 && south[i] == 0)
			south[i] = j-1;
		}
	    }
	    out.println(dp(0,b));
	}
	out.flush();
	out.close();
    }
    static class Scanner{
	BufferedReader bf;
	StringTokenizer st;
	public Scanner(InputStream s){
	    bf = new BufferedReader(new InputStreamReader(s));
	}
	public Scanner(FileReader f)
	{
	    bf = new BufferedReader(f);
	}
	public String next() throws IOException{
	    while(st == null || !st.hasMoreTokens())
		st = new StringTokenizer(bf.readLine());
	    return st.nextToken();
	}
	public String nextLine() throws IOException{
	    return bf.readLine();
	}
	public int nextInt() throws NumberFormatException, IOException{
	    return Integer.parseInt(next());
	}
	public boolean ready() throws IOException{
	    return bf.ready();
	}
    }
}