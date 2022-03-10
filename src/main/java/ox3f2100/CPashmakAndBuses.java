package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPashmakAndBuses {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int d = in.nextInt();
    long tmp = 1;
    boolean f = false;
    for (int i = 0; i < d; i++) {
      tmp *= k;
      if (tmp >= n) {
        f = true;
        break;
      }
    }
    if (!f) {
      out.println(-1);
      return;
    }
    int[][] res = new int[n][d];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < d; j++) {
        if (i > 0) {
          res[i][j] = res[i - 1][j];
        }
      }
      for (int j = 0; j < d; j++) {
        if (i > 0) {
          res[i][j] = (res[i - 1][j] + 1) % k;
          if (res[i][j] != 0) {
            break;
          }
        }
      }
    }
    for (int j = 0; j < d; j++) {
      for (int i = 0; i < n; i++) {
        out.print(res[i][j] + 1, "");
      }
      out.println();
    }
  }
}
