package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BTheLeastRoundWay {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int[][][] dp = new int[n + 1][n + 1][2];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        Arrays.fill(dp[i][j], (int) 1e8);
      }
    }
    dp[0][1][0] = dp[0][1][1] = 0;
    dp[1][0][0] = dp[1][0][1] = 0;
    boolean zero = false;
    int zx = 0;
    int zy = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j][0] = Math.min(dp[i - 1][j][0], dp[i][j - 1][0]);
        dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
        if (a[i][j] == 0) {
          zero = true;
          zx = i;
          zy = j;
          continue;
        }
        int t = a[i][j];
        int t2 = 0;
        while (t % 2 == 0) {
          t /= 2;
          t2++;
        }
        dp[i][j][0] += t2;
        int t5 = 0;
        while (t % 5 == 0) {
          t /= 5;
          t5++;
        }
        dp[i][j][1] += t5;
      }
    }
    int res = Math.min(dp[n][n][0], dp[n][n][1]);
    if (zero && res >= 1) {
      out.println(1);
      for (int i = 1; i <= zx - 1; i++) {
        out.print("D");
      }
      for (int i = 1; i <= zy - 1; i++) {
        out.print("R");
      }
      for (int i = zx; i <= n - 1; i++) {
        out.print("D");
      }
      for (int i = zy; i <= n - 1; i++) {
        out.print("R");
      }
    } else {
      int k = 0;
      if (res == dp[n][n][1]) {
        k = 1;
      }
      int x = n;
      int y = n;
      StringBuilder sb = new StringBuilder();
      while (x != 1 || y != 1) {
        int t = a[x][y];
        int[] tmp = new int[2];
        while (t % 2 == 0) {
          t /= 2;
          tmp[0]++;
        }
        while (t % 5 == 0) {
          t /= 5;
          tmp[1]++;
        }
        if (dp[x][y][k] == dp[x - 1][y][k] + tmp[k]) {
          sb.append("D");
          x--;
        } else {
          sb.append("R");
          y--;
        }
      }
      out.println(res);
      out.println(sb.reverse().toString());
    }
  }
}
