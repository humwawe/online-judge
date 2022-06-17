package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BKaviOnPairingDuty {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    int mod = 998244353;
    long x = 0;
    long[] dp = new long[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j += i) {
        dp[j]++;
      }
    }

    long sum = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] += sum;
      dp[i] %= mod;
      sum += dp[i];
      sum %= mod;
    }
    out.println(dp[n]);
  }
}
