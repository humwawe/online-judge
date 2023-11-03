package ccf.csp.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] h = in.nextInt(n);
    int res = 0;
    for (int i = 0; i < n; i++) {
      int min = h[i];
      for (int j = i; j < n; j++) {
        min = Math.min(min, h[j]);
        res = Math.max(res, (j - i + 1) * min);

      }
    }
    out.println(res);
  }
}
