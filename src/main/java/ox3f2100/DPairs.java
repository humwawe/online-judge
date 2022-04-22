package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DPairs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    boolean[] vis = new boolean[2 * n + 1];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      vis[x] = true;
    }
    int cnt = 0;
    int max = 0;
    int min = 0;
    for (int i = 1; i <= 2 * n; i++) {
      if (vis[i]) {
        cnt++;
      } else {
        cnt--;
      }
      max = Math.max(max, cnt);
      min = Math.min(min, cnt);
    }
    out.println(Math.abs(max - (n + min)) + 1);
  }
}
