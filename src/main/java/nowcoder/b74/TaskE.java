package nowcoder.b74;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long m = in.nextInt() - 1;
    long k = in.nextInt();
    long b = in.nextInt();
    int[] h = in.nextInt(n);
    int[] a = in.nextInt(n);

    long[] res = new long[n];

    for (int i = 0; i < n; i++) {

      if (h[i] + m * a[i] <= k) {
        res[i] = h[i] + m * a[i];
        continue;
      }

      long cur = b;
      long last = m - (k - h[i] + 1 + (a[i] - 1)) / a[i];

      long dem = (k - b + 1 + (a[i] - 1)) / a[i];
      last %= dem;
      res[i] = cur + last * a[i];
    }
    out.println(res);
  }
}
