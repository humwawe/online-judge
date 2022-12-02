package nowcoder.cc106;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = in.nextInt(n);
    long res = 0;
    for (int i = 0; i < n; i++) {
      res += Math.abs(a[i] - b[i]);
    }
    if (res == 0) {
      out.println(0);
      return;
    }
    out.println(res + 2 * n);
  }
}
