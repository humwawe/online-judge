package acwing.contest.weekly.c88;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[][] dp = new int[n + 1][3];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], (int) 1e5);
    }

    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      dp[i][0] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + 1;
      if (a[i - 1] == 1) {
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]);
      }
      if (a[i - 1] == 2) {
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]);
      }
      if (a[i - 1] == 3) {
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]);
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]);
      }
    }


    out.println(min(dp[n][0], dp[n][1], dp[n][2]));

  }

  private int min(int... a) {
    int res = (int) 1e6;
    for (int i : a) {
      res = Math.min(i, res);
    }
    return res;
  }
}
