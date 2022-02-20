package codeforces.c726;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AArithmeticArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += in.nextInt();
    }
    if (sum == n) {
      out.println(0);
    } else if (sum < n) {
      out.println(1);
    } else {
      out.println(sum - n);
    }
  }
}
