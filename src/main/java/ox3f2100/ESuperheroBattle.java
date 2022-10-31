package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ESuperheroBattle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long h = in.nextLong();
    int n = in.nextInt();
    int[] d = new int[n];
    long[] cum = new long[n + 1];


    for (int i = 0; i < n; i++) {
      d[i] = -in.nextInt();
      cum[i + 1] = cum[i] + d[i];
    }
    long sum = 0;

    for (int i = 0; i < n; i++) {
      sum += d[i];
      if (h - sum <= 0) {
        out.println(i + 1);
        return;
      }
    }

    if (sum <= 0) {
      out.println(-1);
      return;
    }
    long res = (long) 1e18;
    for (int i = 1; i <= n; i++) {
      long z = (h - cum[i] + sum - 1) / sum;
      res = Math.min(res, z * n + i);
    }
    out.println(res);

  }
}
