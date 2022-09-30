package codeforces.g116;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMedianMaximization {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int s = in.nextInt();
    out.println(s / (n / 2 + 1));
  }
}
