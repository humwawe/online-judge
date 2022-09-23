package codeforces.c822;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CRemovingSmallestMultiples {

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.nextInt();
    String s = in.nextString();
    long res = 0;
    boolean[] vis = new boolean[n + 1];
    for (int i = 1; i <= s.length(); i++) {

      if (s.charAt(i - 1) == '0') {
        if (!vis[i]) {
          res += i;
          vis[i] = true;
        }

        for (int j = i + i; j <= n; j += i) {
          if (vis[j]) {
            continue;
          }
          if (s.charAt(j - 1) == '0') {
            res += i;
            vis[j] = true;
          } else {
            break;
          }
        }
      }
    }
    out.println(res);
  }


}
