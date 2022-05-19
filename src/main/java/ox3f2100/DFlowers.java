package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DFlowers {
  int N = (int) (1e5 + 5);


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    int k = in.nextInt();
    int mod = (int) (1e9 + 7);
    long[] dp = new long[N];
    dp[0] = 1;
    for (int i = 1; i < N; i++) {
      dp[i] = dp[i - 1];
      if (i >= k) {
        dp[i] = (dp[i] + dp[i - k]) % mod;
      }
    }

    for (int i = 1; i < N; i++) {
      dp[i] += dp[i - 1];
    }

    for (int i = 0; i < t; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      out.println((dp[b] - dp[a - 1]) % mod);
    }
  }
}
