package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DNewYearsProblem {
  int[][] a;
  int m, n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    m = in.nextInt();
    n = in.nextInt();
    a = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int l = 1;
    int r = (int) 1e9;
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
    int[] cnt = new int[m];
    for (int i = 0; i < n; i++) {
      boolean f = false;
      for (int j = 0; j < m; j++) {
        if (a[j][i] >= mid) {
          cnt[j]++;
          f = true;
        }
      }
      if (!f) {
        return false;
      }
    }
    for (int i = 0; i < m; i++) {
      if (cnt[i] >= 2) {
        return true;
      }
    }
    return false;
  }
}
