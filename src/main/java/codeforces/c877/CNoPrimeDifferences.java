package codeforces.c877;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CNoPrimeDifferences {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.nextInt();
    int m = in.nextInt();

    for (int i = 1; i < n; i += 2) {
      for (int j = 1; j <= m; j++) {
        out.print(i * m + j, "");
      }
      out.println();
    }
    for (int i = 0; i < n; i += 2) {
      for (int j = 1; j <= m; j++) {
        out.print(i * m + j, "");
      }
      out.println();
    }
    out.println();
  }
}
