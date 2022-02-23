package codeforces.e123;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CIncreaseSubarraySums {
  int n, x;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    x = in.nextInt();
    a = new int[n];
    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum[i + 1] = sum[i] + a[i];
    }
    int[] d = new int[n + 1];
    int inf = (int) 1e9;
    Arrays.fill(d, -inf);

    for (int len = 0; len <= n; len++) {
      for (int i = 0; i < n; i++) {
        int j = i + len;
        if (j > n) {
          break;
        }
        d[len] = Math.max(d[len], sum[j] - sum[i]);
      }
    }
    int res = 0;

    for (int len = 0; len <= n; len++) {
      for (int i = len; i <= n; i++) {
        res = Math.max(res, d[i] + (x * len));
      }
      out.print(res, "");
    }

    out.println();
  }
}
