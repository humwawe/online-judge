package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskJ {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] d = new int[n];
    d[0] = a[0];
    int res = d[0];
    for (int i = 1; i < n; i++) {
      d[i] = a[i] - a[i - 1];
      if (d[i] > 0) {
        res += d[i];
      }
    }
    out.println(res);
  }
}
