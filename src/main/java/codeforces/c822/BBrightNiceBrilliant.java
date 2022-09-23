package codeforces.c822;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BBrightNiceBrilliant {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      if (i == 1) {
        out.println(1);
      } else if (i == 2) {
        out.println(1, 1);
      } else {
        out.print(1, "");
        for (int j = 1; j <= i - 2; j++) {
          out.print(0, "");
        }
        out.println(1);
      }
    }
  }
}
