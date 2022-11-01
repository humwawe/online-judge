package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class FIntervalsOnTree {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] cnt = new long[n + 1];
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      if (a > b) {
        int t = a;
        a = b;
        b = t;
      }
      cnt[b] += a;
    }

    long res = 0;
    long last = 0;
    for (int i = 1; i <= n; i++) {
      res += last + i - cnt[i];
      last += i - cnt[i];
    }
    out.println(res);
  }
}
