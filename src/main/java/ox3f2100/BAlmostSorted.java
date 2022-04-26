package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BAlmostSorted {
  long inf = (long) 2e18;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    long k = in.nextLong();
    long x = 1;
    if (n < 62 && (1L << (n - 1)) < k) {
      out.println(-1);
      return;
    }
    int j = 1;
    int last = 1;
    while (j <= n) {
      while (j + 1 <= n && power(last, j + 1) < k) {
        j++;
      }
      k -= power(last, j);
      for (int l = j; l >= last; l--) {
        out.print(l, "");
      }
      last = j + 1;
      j++;
    }
    out.println();
  }

  private long power(int l, int r) {
    long res = 0;
    for (int i = l; i <= r - 1; i++) {
      if (n - i - 1 >= 60) {
        return inf;
      }
      res += (1L << (n - i - 1));
    }
    return res;
  }
}
