package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CBarcode {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }

    int[] b = new int[m];
    for (int j = 0; j < m; j++) {
      for (int i = 0; i < n; i++) {
        if (a[i][j] == '#') {
          b[j]++;
        }
      }
    }
    int[] sb = new int[m + 1];
    for (int i = 0; i < m; i++) {
      sb[i + 1] = sb[i] + b[i];
    }

    int inf = (int) 1e9;
    int[][] dp = new int[m + 1][2];

    for (int i = 0; i < m + 1; i++) {
      Arrays.fill(dp[i], inf);
    }

    dp[0][0] = 0;
    dp[0][1] = 0;

    for (int i = 1; i <= m; i++) {

      for (int j = i - y + 1; j <= i - x + 1; j++) {
        if (j - 1 >= 0) {
          dp[i][0] = Math.min(dp[i][0], dp[j - 1][1] + sb[i] - sb[j - 1]);
          dp[i][1] = Math.min(dp[i][1], dp[j - 1][0] + n * (i - j + 1) - (sb[i] - sb[j - 1]));
        }
      }
    }

    out.println(Math.min(dp[m][0], dp[m][1]));
  }
}
