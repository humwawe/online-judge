package acwing.contest.weekly.c69;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    String s = Integer.toBinaryString(a);
    long x = 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        x *= 2;
      }
    }
    out.println(x);
  }
}
