package codeforces.c832;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ATwoGroups {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long sum1 = 0;
    long sum2 = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (x >= 0) {
        sum1 += x;
      } else {
        sum2 += x;
      }
    }
    out.println(Math.abs(sum1 + sum2));
  }
}
