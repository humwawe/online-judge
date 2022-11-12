package acwing.contest.weekly.c77;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    char[] res = new char[n];
    String s = "ROYGBIV";
    int i = 0;
    for (i = 0; i < n - 4; i++) {
      res[i] = s.charAt(i % s.length());
    }

    for (; i < n; i++) {
      for (int j = 6; j >= 0; j--) {
        boolean f = true;
        for (int k = 1; k <= 3; k++) {
          if (res[i - k] == s.charAt(j)) {
            f = false;
          }
          if (res[(i + k) % n] == s.charAt(j)) {
            f = false;
          }
        }
        if (f) {
          res[i] = s.charAt(j);
          break;
        }
      }
    }

    out.println(res);
  }
}
