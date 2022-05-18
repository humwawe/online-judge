package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMittens {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    int[] cnt = new int[m + 1];
    int max = 0;
    for (int i = 0; i < n; i++) {
      x[i] = in.nextInt();
      y[i] = x[i];
      cnt[x[i]] += 2;
      max = Math.max(max, cnt[x[i]]);
    }
    if (max <= n) {
      out.println(n);
    } else {
      out.println(2 * n - max);
    }

    for (int i = 0; i < n; i++) {
      if (x[i] != y[i]) {
        continue;
      }
      for (int j = 0; j < n; j++) {
        if (x[j] != y[i] && x[i] != y[j]) {
          int t = x[i];
          x[i] = x[j];
          x[j] = t;
        } else if (x[i] != y[j] && x[j] != y[i]) {
          int t = y[i];
          y[i] = y[j];
          y[j] = t;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      out.println(x[i], y[i]);
    }

  }


}
