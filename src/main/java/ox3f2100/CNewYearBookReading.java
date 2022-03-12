package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CNewYearBookReading {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[m];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt();
    }

    int res = 0;
    for (int i = 0; i < m; i++) {
      int sum = 0;
      boolean[] vis = new boolean[505];
      for (int j = i - 1; j >= 0; j--) {
        if (b[j] == b[i]) {
          break;
        }
        if (!vis[b[j]]) {
          sum += a[b[j] - 1];
        }
        vis[b[j]] = true;
      }
      res += sum;
    }
    out.println(res);

  }
}
