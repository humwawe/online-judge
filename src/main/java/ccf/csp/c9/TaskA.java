package ccf.csp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (a[j] > a[i]) {
          cnt += 1;
        } else if (a[j] < a[i]) {
          cnt -= 1;
        }
      }
      if (cnt == 0) {
        out.println(a[i]);
        return;
      }
    }
    out.println(-1);
  }
}
