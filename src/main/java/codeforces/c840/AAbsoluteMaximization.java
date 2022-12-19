package codeforces.c840;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AAbsoluteMaximization {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int max = 0;
    int min = 1023;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      for (int j = 0; j < 11; j++) {
        if ((x >> j & 1) == 1) {
          max |= 1 << j;
        } else {
          min &= ~(1 << j);
        }
      }
    }
    out.println(max - min);
  }
}
