package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAnyaAndGhosts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int t = in.nextInt();
    int r = in.nextInt();
    int[] a = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt();
    }
    if (t < r) {
      out.println(-1);
      return;
    }
    boolean[] b = new boolean[3005];
    int res = 0;
    for (int k = 0; k < m; k++) {
      int u = a[k] + t;
      int sum = 0;
      for (int i = u; i > u - t; i--) {
        if (b[i]) {
          sum++;
        }
      }
      for (int i = u; sum < r; i--) {
        if (!b[i]) {
          b[i] = true;
          sum++;
          res++;
        }
      }
    }
    out.println(res);
  }
}
