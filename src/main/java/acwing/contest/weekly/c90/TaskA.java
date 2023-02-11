package acwing.contest.weekly.c90;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    String s1 = s.toUpperCase();
    out.println(s1.charAt(0) + s.substring(1));

  }
}
