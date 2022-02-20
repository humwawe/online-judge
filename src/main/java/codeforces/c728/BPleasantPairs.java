package codeforces.c728;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPleasantPairs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] vis = new int[2 * n + 5];
    for (int i = 1; i <= n; i++) {
      vis[in.nextInt()] = i;
    }
    int lim = 2 * n - 1;
    int res = 0;
    for (int num = 3; num <= lim; num++) {
      for (int i = 1; i * i < num; i++) {
        if (num % i == 0) {
          int o = num / i;
          if (vis[i] != 0 && vis[o] != 0) {
            if (vis[i] + vis[o] == num) {
              res++;
            }
          }
        }
      }
    }
    out.println(res);
  }
}
