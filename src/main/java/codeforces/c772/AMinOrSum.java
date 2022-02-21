package codeforces.c772;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMinOrSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int res = 0;
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      for (int j = 0; j < 30; j++) {
        if (((a >> j) & 1) == 1) {
          res |= 1 << j;
        }
      }
    }
    out.println(res);
  }
}
