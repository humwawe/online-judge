package codeforces.e131;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    boolean[] vis = new boolean[n + 1];
    int d = 2;
    out.println(d);
    for (int i = 1; i <= n; i++) {
      if (vis[i]) {
        continue;
      }

      int t = i;
      while (t <= n) {
        vis[t] = true;
        out.print(t, "");
        t *= d;
      }
    }
    out.println();
  }
}
