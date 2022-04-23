package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BALeapfrogInTheArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      long x = in.nextLong();
      while (x % 2 == 0) {
        x = n + x / 2;
      }
      out.println((x + 1) / 2);
    }

  }
}
