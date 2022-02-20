package codeforces.c768;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAndMatching {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    if (n == 4 && k == 3) {
      out.println(-1);
      return;
    }
    if (k == n - 1) {
      out.println("0 1");
      out.println(n - 1 + " " + (n - 2));
      out.println(n / 2 - 2, n / 2);
      out.println(n / 2 - 1, n / 2 + 1);
      for (int i = 2; i < n / 2 - 2; i++) {
        out.println(i, n - i - 1);
      }
      return;
    }
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (vis[i]) {
        continue;
      }
      if (i == 0) {
        out.println(0, n - 1 - k);

        vis[i] = true;
        vis[n - 1 - k] = true;
      } else if (i == k) {
        out.println(k, n - 1);
        vis[k] = true;
        vis[n - 1] = true;
      } else {
        out.println(i, n - 1 - i);
        vis[i] = true;
        vis[n - 1 - i] = true;
      }
    }
  }
}
