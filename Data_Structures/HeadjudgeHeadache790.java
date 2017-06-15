package DataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HeadjudgeHeadache790 {
    public static void main(String[] args) throws Exception
    {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	bf.readLine();
	while (n-- > 0)
	{
	    int max = 0;
	    Team[] scoreBoard = new Team[25];
	    for (int i = 0; i < scoreBoard.length; i++)
		scoreBoard[i] = new Team(i);
	    String str = bf.readLine();
	    ArrayList<query> q = new ArrayList<query>();
	    while (str != null && !str.isEmpty())
	    {
		st = new StringTokenizer(str);
		q.add(new query(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		str = bf.readLine();
	    }
	    Collections.sort(q);
	    for (int i = 0; i < q.size(); i++)
	    {
		query status = q.get(i);
		// int t = Integer.parseInt(st.nextToken())-1;
		max = Math.max(status.t, max);
		// char p = st.nextToken().charAt(0);
		// String tmp = st.nextToken();
		// int time =
		// Integer.parseInt(tmp.substring(0,tmp.indexOf(":")))*60 +
		// Integer.parseInt(tmp.substring(tmp.indexOf(":")+1,tmp.length()));
		// boolean s = st.nextToken().charAt(0)=='Y'? true:false;
		if (status.s)
		{
		    if (scoreBoard[status.t].submissions.get(status.p) != null)
		    {
			if (!scoreBoard[status.t].submissions.get(status.p).solved)
			{
			    scoreBoard[status.t].problems++;
			    scoreBoard[status.t].timeMin += ((scoreBoard[status.t].submissions.get(status.p).tries * 20)
				    + status.time);
			}
		    } else
		    {
			scoreBoard[status.t].problems++;
			scoreBoard[status.t].timeMin += status.time;
		    }
		}
		scoreBoard[status.t].submissions.put(status.p,
			new Pair(status.s, scoreBoard[status.t].submissions.containsKey(status.p)
				? scoreBoard[status.t].submissions.get(status.p).tries + 1 : 1));

	    }
	    Arrays.sort(scoreBoard);
	    out.println("RANK TEAM PRO/SOLVED TIME");
	    int rank = 1;
	    int count = 0;
	    Team prev = scoreBoard[0];
	    for (int i = 0; i < scoreBoard.length; i++)
	    {
		if (scoreBoard[i].number <= max)
		{
		    if (scoreBoard[i].compareTo(prev) != 0)
		    {
			rank += count;
			count = 1;
		    } else
			count++;
		    if (scoreBoard[i].problems > 0)
			out.printf("%4d %4d %4d       %4d\n", rank, scoreBoard[i].number + 1, scoreBoard[i].problems,
				scoreBoard[i].timeMin);

		    else
			out.printf("%4d %4d\n", rank, scoreBoard[i].number + 1);
		    prev = scoreBoard[i];
		}
	    }
	    out.println();
	}
	out.flush();
	out.close();
    }

    static class Team implements Comparable<Team> {
	int number;
	int problems;
	int timeMin;
	HashMap<Character, Pair> submissions;

	public Team(int n)
	{
	    number = n;
	    problems = 0;
	    timeMin = 0;
	    submissions = new HashMap<Character, Pair>();
	}

	public int compareTo(Team t)
	{
	    if (problems != t.problems)
		return t.problems - problems;
	    else
		return timeMin - t.timeMin;
	}
    }

    static class Pair {
	boolean solved;
	int tries;

	public Pair(boolean s, int t)
	{
	    solved = s;
	    tries = t;
	}
    }

    static class query implements Comparable<query> {
	int t;
	char p;
	int time;
	boolean s;

	public query(String team, String problem, String T, String solved)
	{
	    t = Integer.parseInt(team) - 1;
	    p = problem.charAt(0);
	    time = Integer.parseInt(T.substring(0, T.indexOf(":"))) * 60
		    + Integer.parseInt(T.substring(T.indexOf(":") + 1, T.length()));
	    s = solved.charAt(0) == 'Y' ? true : false;
	}

	public int compareTo(query q)
	{
	    return time - q.time;
	}
    }
}
