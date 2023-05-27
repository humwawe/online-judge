package codeforces.e149;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AGrasshopperOnALine {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    int k = in.nextInt();
    if (x % k != 0) {
      out.println(1);
      out.println(x);
      return;
    }
    out.println(2);
    out.println(x - 1, 1);
  }
}
