package atcoder.abc303;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DShiftVsCapsLock {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x = in.nextInt();
    long y = in.nextInt();
    long z = in.nextInt();
    String s = in.nextString();
    long inf = (long) 1e17;
    long[][] dp = new long[s.length() + 1][2];
    dp[0][0] = 0;
    dp[0][1] = inf;

    for (int i = 1; i <= s.length(); i++) {

      if (s.charAt(i - 1) == 'A') {
        dp[i][0] = Math.min(dp[i - 1][0] + y, dp[i - 1][1] + z + y);
        dp[i][1] = Math.min(dp[i - 1][0] + z + x, dp[i - 1][1] + x);
      } else {
        dp[i][0] = Math.min(dp[i - 1][0] + x, dp[i - 1][1] + z + x);
        dp[i][1] = Math.min(dp[i - 1][0] + z + y, dp[i - 1][1] + y);
      }
    }

    out.println(Math.min(dp[s.length()][0], dp[s.length()][1]));
  }
}
