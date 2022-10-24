package atcoder.abc274;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DRobotArms2 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    int[] a = in.nextInt(n);
    int N = (int) 1e4 + 5;

    boolean[][] dp = new boolean[n][2 * N];
    boolean[][] dp2 = new boolean[n][2 * N];
    dp[0][a[0] + N] = true;
    dp2[1][a[1] + N] = true;
    dp2[1][-a[1] + N] = true;

    for (int i = 2; i < n; i++) {
      if (i % 2 == 0) {
        for (int j = -N + 1; j < N; j++) {
          if (dp[i - 2][j + N]) {
            dp[i][j - a[i] + N] |= dp[i - 2][j + N];
            dp[i][j + a[i] + N] |= dp[i - 2][j + N];
          }
        }
      } else {
        for (int j = -N + 1; j < N; j++) {
          if (dp2[i - 2][j + N]) {
            dp2[i][j - a[i] + N] |= dp2[i - 2][j + N];
            dp2[i][j + a[i] + N] |= dp2[i - 2][j + N];
          }
        }
      }
    }

    int l1 = n - 1;
    int l2 = n - 2;
    if (n % 2 == 0) {
      l1 = n - 2;
      l2 = n - 1;
    }
    if (dp[l1][x + N] && dp2[l2][y + N]) {
      out.println("Yes");
    } else {
      out.println("No");
    }


  }
}
