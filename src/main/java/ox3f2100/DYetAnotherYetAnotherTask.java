package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DYetAnotherYetAnotherTask {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int res = 0;
    for (int cur = 1; cur <= 30; cur++) {
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += a[i];
        if (a[i] > cur) {
          sum = 0;
        }
        if (sum < 0) {
          sum = 0;
        }
        res = Math.max(res, sum - cur);
      }
    }

    out.println(res);
  }
}
