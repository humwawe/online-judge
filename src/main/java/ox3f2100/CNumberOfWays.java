package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CNumberOfWays {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long sum = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    if (sum % 3 != 0) {
      out.println(0);
      return;
    }
    sum /= 3;
    long t = 0;
    long res = 0;
    int[] dp = new int[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      t += a[i];
      if (t == sum) {
        dp[i] = dp[i + 1] + 1;
      } else {
        dp[i] = dp[i + 1];
      }
    }
    t = 0;
    for (int i = 0; i < n - 1; i++) {
      t += a[i];
      if (t == sum) {
        res += dp[i + 2];
      }
    }
    out.println(res);
  }
}
