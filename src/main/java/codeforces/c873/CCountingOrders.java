package codeforces.c873;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CCountingOrders {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = in.nextInt(n);
    Arrays.sort(a);
    Arrays.sort(b);
    long res = 1;
    int mod = (int) (1e9 + 7);
    int j = -1;
    for (int i = 0; i < n; i++) {
      while (j + 1 < n && b[j + 1] < a[i]) {
        j++;
      }
      if (j >= i) {
        res = res * (j - i + 1) % mod;
      } else {
        out.println(0);
        return;
      }
    }
    out.println(res);

  }
}
