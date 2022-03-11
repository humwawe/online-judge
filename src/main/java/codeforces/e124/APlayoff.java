package codeforces.e124;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APlayoff {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    out.println((1 << n) - 1);
  }
}
