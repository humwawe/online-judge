package acwing.contest.weekly.c66;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    if ((s.charAt(s.length() - 1) - '0') % 2 == 0) {
      out.println(0);
    } else {
      out.println(1);
    }
  }
}
