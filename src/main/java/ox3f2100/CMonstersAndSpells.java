package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMonstersAndSpells {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] k = new int[n];
    int[] h = new int[n];
    for (int i = 0; i < n; i++) {
      k[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      h[i] = in.nextInt();
    }
    int[] dp = new int[n];
    dp[n - 1] = h[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      dp[i] = Math.max(h[i], dp[i + 1] - (k[i + 1] - k[i]));
    }

    long res = (long) (1 + dp[0]) * dp[0] / 2;
    long x = dp[0];

    for (int i = 1; i < n; i++) {
      if (dp[i] <= k[i] - k[i - 1]) {
        res += (long) (1 + dp[i]) * dp[i] / 2;
        x = dp[i];
      } else {
        res += (x + 1 + x + k[i] - k[i - 1]) * (k[i] - k[i - 1]) / 2;
        x += k[i] - k[i - 1];

      }
    }

    out.println(res);

  }
}
