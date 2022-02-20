package code.jam.o2021.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Matrygons {
  int N = 333334;
  int[] dp = new int[N + 1];
  int n;

  {
    dfs(1, 1, 1);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int res = 1;
    for (int i = 3; i * 2 <= n; i++) {
      if (n % i == 0) {
        res = Math.max(res, dp[n / i]);
      }
    }
    out.printf("Case #%d: %d\n", testNumber, res);
  }

  void dfs(int cur, int head, int dep) {
    dp[cur] = Math.max(dp[cur], dep);
    for (int i = head * 2; cur + i <= N; i += head) {
      dfs(cur + i, i, dep + 1);
    }
  }


}
