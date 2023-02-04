package acwing.contest.weekly.c88;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();

    for (int i = x + 1; i <= 10234; i++) {
      if (check(i)) {
        out.println(i);
        return;
      }
    }
  }

  private boolean check(int i) {
    String s = String.valueOf(i);
    for (int j = 0; j < s.length(); j++) {
      for (int k = j + 1; k < s.length(); k++) {
        if (s.charAt(j) == s.charAt(k)) {
          return false;
        }
      }
    }
    return true;

  }
}
