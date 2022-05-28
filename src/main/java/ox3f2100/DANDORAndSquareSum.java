package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DANDORAndSquareSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] cnt = new int[25];
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      for (int j = 0; j <= 20; j++) {
        if (((x >> j) & 1) == 1) {
          cnt[j]++;
        }
      }
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      long cur = 0;
      for (int j = 0; j <= 20; j++) {
        if (cnt[j] > 0) {
          cnt[j]--;
          cur += 1 << j;
        }
      }
      res += cur * cur;
    }
    out.println(res);
  }
}
