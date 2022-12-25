package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }

    int[] dp = new int[m + 1];

    dp[0] = 1;
    for (int i = 1; i <= n; ++i) {
      for (int j = m; j >= a[i]; --j) {
        dp[j] += dp[j - a[i]];
        dp[j] %= 10;
      }
    }


    int[] g = new int[m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (j < a[i]) {
          g[j] = dp[j];
        } else {
          g[j] = (dp[j] - g[j - a[i]] + 10) % 10;
        }
      }
      for (int j = 1; j <= m; j++) {
        out.print(g[j]);
      }
      out.println();
    }

  }
}
