package codeforces.c876;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ATheGoodArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n + 1];
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      int cur = (i + k - 1) / k;
      cnt += a[i];
      if (cnt < cur) {
        cnt++;
        a[i] = 1;
        if (i <= n / 2) {
          a[n - i + 1] = 1;
        }

      }
    }
    int res = 0;
    for (int i = 1; i <= n; i++) {
      res += a[i];
    }
    out.println(res);
  }
}
