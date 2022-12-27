package codeforces.c841;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DValiantsNewMap {
  int[][] a;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int l = 1;
    int r = Math.min(n, m);
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    out.println(l);
  }

  private boolean check(int mid) {
    int s = mid * mid;
    int[][] sum = new int[n + 1][m + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + (a[i][j] >= mid ? 1 : 0);
        if (twoQuery(sum, i - mid + 2, j - mid + 2, i + 1, j + 1) == s) {
          return true;
        }
      }
    }

    return false;
  }

  int twoQuery(int[][] sum, int x1, int y1, int x2, int y2) {
    if (x1 >= 1 && x1 <= n && x2 >= 1 && x2 <= n && y1 >= 1 && y1 <= m && y2 >= 1 && y2 <= m) {
      return sum[x2][y2] + sum[x1 - 1][y1 - 1] - sum[x1 - 1][y2] - sum[x2][y1 - 1];
    }
    return 0;
  }
}
