package codeforces.c810;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BParty {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    int[] cnt = new int[n + 1];
    int[] x = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; i++) {
      x[i] = in.nextInt();
      y[i] = in.nextInt();
      cnt[x[i]]++;
      cnt[y[i]]++;
    }
    if (m % 2 == 0) {
      out.println(0);
      return;
    }

    long res = sum;

    for (int i = 1; i <= n; i++) {
      if (cnt[i] % 2 == 1) {
        res = Math.min(res, a[i - 1]);
      }
    }
    for (int i = 0; i < m; i++) {
      if ((cnt[x[i]] + cnt[y[i]]) % 2 == 0) {
        res = Math.min(res, a[x[i] - 1] + a[y[i] - 1]);
      }

    }
    out.println(res);

  }
}
