package atcoder.abc311;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EDefectFreeSquares {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int h = in.nextInt();
    int w = in.nextInt();
    int n = in.nextInt();
    boolean[][] hole = new boolean[h][w];
    for (int i = 0; i < n; i++) {
      hole[in.nextInt() - 1][in.nextInt() - 1] = true;
    }
    int[][] dp = new int[h + 1][w + 1];

    long res = 0;


    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (hole[i][j]) {
          continue;
        }
        dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
        res += dp[i + 1][j + 1];
      }
    }


    out.println(res);

  }
}
