package codeforces.c740;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BCharmedByTheGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    if (a > b) {
      int t = a;
      a = b;
      b = t;
    }
    int c = a + b;
    int TA = (c + 1) / 2;
    int cnt = 0;
    boolean[] vis = new boolean[c + 1];
    for (int i = 0; i <= a; i++) {
      int tmp = (a - i) + (TA - i);
      int tmp2 = c - tmp;
      if (!vis[tmp]) {
        cnt++;
        vis[tmp] = true;
      }
      if (!vis[tmp2]) {
        cnt++;
        vis[tmp2] = true;
      }

    }
    out.println(cnt);
    for (int i = 0; i <= c; i++) {
      if (vis[i]) {
        out.print(i + " ");
      }
    }
    out.println();
  }
}
