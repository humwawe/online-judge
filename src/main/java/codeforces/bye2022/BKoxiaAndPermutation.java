package codeforces.bye2022;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BKoxiaAndPermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    if (k == 1) {
      for (int i = 1; i <= n; i++) {
        out.print(i, "");
      }
      out.println();
      return;
    }

    int max = n;
    int min = 1;
    int cnt = 0;
    while (cnt != n) {
      for (int i = 0; i < k - 1; i++) {
        out.print(max--, "");
        cnt++;
        if (cnt == n) {
          out.println();
          return;
        }
      }
      for (int i = 0; i < k - 1; i++) {
        out.print(min++, "");
        cnt++;
        if (cnt == n) {
          out.println();
          return;
        }
      }
    }
  }
}
