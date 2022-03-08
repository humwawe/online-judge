package codeforces.c775;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DIntegralArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int c = in.nextInt();
    int[] a = new int[c + 1];
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      a[t] = 1;
    }
    int[] sum = new int[c + 1];
    for (int i = 1; i <= c; i++) {
      sum[i] = sum[i - 1] + a[i];
    }

    for (int i = 1; i <= c; i++) {
      if (a[i] > 0) {
        for (int j = 1; j * i <= c; j++) {
          if (a[j] == 0) {
            int r = Math.min(c, (j + 1) * i - 1);
            int l = j * i - 1;
            if (sum[r] - sum[l] > 0) {
              out.println("No");
              return;
            }
          }
        }
      }
    }
    out.println("Yes");
  }

}
