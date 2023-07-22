package atcoder.abc311;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class FYetAnotherGridTask {

  int mod = 998244353;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();

    char[][] s = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        s[i][j] = in.nextCharacter();
      }
    }
    int[] lm = new int[m];
    for (int i = 0; i < m; i++) {
      lm[i] = n;
      for (int j = 0; j < n; j++) {
        if (s[j][i] == '#') {
          lm[i] = j;
          break;
        }
      }
    }
    long[][] dp = new long[m + 1][n + 1];
    dp[0][n] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j <= lm[i]; j++) {
        dp[i + 1][j] = sum(dp[i], j - 1, n);
      }
      for (int j = 0; j < n; j++) {
        dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i + 1][j]) % mod;
      }
    }
    out.println(sum(dp[m], 0, n));

  }  // l <= j <= w

  long sum(long[] a, int l, int r) {
    return l <= 0 ? a[r] : (a[r] + mod - a[l - 1]) % mod;
  }


}
