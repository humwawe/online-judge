package ccf.csp.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    boolean[] vis = new boolean[10005];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      vis[x] = true;
    }
    int res = 0;
    for (int i = 0; i < 10004; i++) {
      if (vis[i] && vis[i + 1]) {
        res++;
      }
    }
    out.println(res);

  }
}
