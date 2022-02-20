package codeforces.c729;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPlusAndMultiply {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long a = in.nextLong();
    long b = in.nextLong();
    if ((n - 1) % b == 0) {
      out.println("Yes");
      return;
    }

    if (a == 1) {
      out.println("No");
      return;
    }
    long tmp = a;
    while (tmp <= n) {
      if ((n - tmp) % b == 0) {
        out.println("Yes");
        return;
      }
      tmp *= a;
    }
    out.println("No");
  }
}
