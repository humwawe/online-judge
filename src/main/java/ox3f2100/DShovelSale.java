package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DShovelSale {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long[] p = new long[15];
    p[0] = 1;
    for (int i = 1; i < 15; i++) {
      p[i] = p[i - 1] * 10;
    }

    int cnt = 0;
    while (p[cnt + 1] - 1 <= n + n - 1) {
      cnt++;
    }
    long res = 0;
    for (int i = 0; i < 9; i++) {
      long sum = p[cnt] * i + p[cnt] - 1;
      long r = Math.min(n, sum - 1);
      long l = Math.max(1, sum - n);
      if (l < r) {
        res += (r - l + 1) / 2;
      }

    }
    out.println(res);
  }
}
