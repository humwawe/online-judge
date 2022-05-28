package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DColoredRectangles {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt();
    int[] a = new int[n1];
    for (int i = 0; i < n1; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n2];
    for (int i = 0; i < n2; i++) {
      b[i] = in.nextInt();
    }
    int[] c = new int[n3];
    for (int i = 0; i < n3; i++) {
      c[i] = in.nextInt();
    }

    Arrays.sort(a);
    Arrays.sort(b);
    Arrays.sort(c);
    rever(a);
    rever(b);
    rever(c);
    int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

    for (int i = 0; i <= n1; i++) {
      for (int j = 0; j <= n2; j++) {
        for (int k = 0; k <= n3; k++) {
          if (i - 1 >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
          }
          if (j - 1 >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k]);
          }
          if (k - 1 >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
          }
          if (i - 1 >= 0 && j - 1 >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k] + a[i - 1] * b[j - 1]);
          }
          if (j - 1 >= 0 && k - 1 >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1] + b[j - 1] * c[k - 1]);
          }
          if (i - 1 >= 0 && k - 1 >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1] + a[i - 1] * c[k - 1]);
          }
        }
      }
    }

    out.println(dp[n1][n2][n3]);

  }

  private void rever(int[] a) {
    int i = 0;
    int j = a.length - 1;
    while (i < j) {
      int t = a[i];
      a[i] = a[j];
      a[j] = t;
      i++;
      j--;
    }
  }
}
