package acwing.contest.weekly.c76;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    String t = in.nextString();
    if (s.equals(new StringBuilder(t).reverse().toString())) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}
