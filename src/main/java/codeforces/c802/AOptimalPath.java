package codeforces.c802;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AOptimalPath {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long res = 0;
    res += (long) m * (m + 1) / 2;
    res += (long) m * n * (n + 1) / 2 - m;
    out.println(res);
  }
}
