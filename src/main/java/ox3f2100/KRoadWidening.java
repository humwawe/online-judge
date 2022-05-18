package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class KRoadWidening {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      b[i] = in.nextInt();
      b[i] += a[i];
    }
    for (int i = 1; i < n; i++) {
      b[i] = Math.min(b[i], b[i - 1] + 1);
    }
    for (int i = n - 2; i >= 0; i--) {
      b[i] = Math.min(b[i], b[i + 1] + 1);
    }
    long sum = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] > b[i]) {
        out.println(-1);
        return;
      }
      sum += b[i] - a[i];
    }
    out.println(sum);
    out.println(b);
  }
}
