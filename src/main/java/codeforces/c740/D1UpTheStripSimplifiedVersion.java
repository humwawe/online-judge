package codeforces.c740;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D1UpTheStripSimplifiedVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int mod = in.nextInt();
    int[] dp = new int[n + 1];
    dp[n] = 1;
    int[] sum = new int[n + 1];
    sum[n] = 1;
    for (int i = n - 1; i >= 1; i--) {
      dp[i] = sum[i + 1];
      for (int j = 2; j * i <= n; j++) {
        if (j * i + j > n) {
          dp[i] = add(dp[i], sum[i * j], mod);
          //                    dp[i] = (dp[i] + sum[i * j]) % mod;
        } else {
          dp[i] = add(dp[i], dec(sum[i * j], sum[j * i + j], mod), mod);
          //                    dp[i] = (dp[i] + (sum[i * j] - sum[j * i + j] + mod) % mod) % mod;
        }
      }
      sum[i] = add(dp[i], sum[i + 1], mod);
      //            sum[i] = (sum[i + 1] + dp[i]) % mod;
    }
    out.println(dp[1]);
  }

  int add(int x, int y, int mod) {
    int t = x + y;
    if (t >= mod) {
      t -= mod;
    }
    return t;
  }

  int dec(int x, int y, int mod) {
    int t = x - y;
    if (t < 0) {
      t += mod;
    }
    return t;
  }
}
