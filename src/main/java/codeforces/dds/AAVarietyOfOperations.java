package codeforces.dds;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AAVarietyOfOperations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int c = in.nextInt();
    int d = in.nextInt();
    if (c == 0 && d == 0) {
      out.println(0);
      return;
    }
    if (c == d) {
      out.println(1);
      return;
    }
    if ((c + d) % 2 == 0) {
      out.println(2);
      return;
    }
    out.println(-1);
  }
}
