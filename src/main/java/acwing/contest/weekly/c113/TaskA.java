package acwing.contest.weekly.c113;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = "abc";
    for (int i = 0; i < n; i++) {
      out.print(s.charAt(i % 3));
    }
    out.println();
  }
}
