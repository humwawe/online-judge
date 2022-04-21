package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCheckpoints {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long k = in.nextLong();
    if (k % 2 == 1) {
      out.println(-1);
      return;
    }

    int[] a = new int[2005];
    int cur = 0;
    a[cur] = 1;
    while (k > 0) {
      int c = 1;
      while ((1L << (c + 1)) - 2 <= k) {
        c++;
      }
      cur += c - 1;
      a[cur] = 1;
      k -= (1L << c) - 2;
    }
    out.println(cur);
    for (int i = 0; i < cur; i++) {
      out.print(a[i], "");
    }
    out.println();
  }
}
