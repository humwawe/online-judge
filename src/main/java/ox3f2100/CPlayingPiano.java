package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CPlayingPiano {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int[] b = new int[n];
    boolean[][] dp = new boolean[n][6];
    int[][] pre = new int[n][6];
    Arrays.fill(dp[0], true);
    for (int i = 1; i < n; i++) {
      for (int prev = 1; prev <= 5; prev++) {
        if (dp[i - 1][prev]) {
          for (int cur = 1; cur <= 5; cur++) {
            if (a[i] == a[i - 1]) {
              if (cur == prev) {
                continue;
              }
              dp[i][cur] = true;
              pre[i][cur] = prev;
            } else if (a[i] > a[i - 1]) {
              if (cur > prev) {
                dp[i][cur] = true;
                pre[i][cur] = prev;
              }
            } else {
              if (cur < prev) {
                dp[i][cur] = true;
                pre[i][cur] = prev;
              }
            }
          }
        }
      }
    }

    for (int i = 1; i <= 5; i++) {
      if (dp[n - 1][i]) {
        b[n - 1] = i;
        break;
      }
    }
    if (b[n - 1] == 0) {
      out.println(-1);
      return;
    }
    int i = n - 1;
    int u = b[n - 1];
    while (i >= 0) {
      if (dp[i][u]) {
        b[i] = u;
        u = pre[i][u];
        i--;

      }
    }
    out.println(b);
  }
}
