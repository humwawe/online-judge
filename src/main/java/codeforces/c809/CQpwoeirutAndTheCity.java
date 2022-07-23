package codeforces.c809;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CQpwoeirutAndTheCity {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n - 2];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n - 2; i++) {
      b[i] = Math.max(0, Math.max(a[i], a[i + 2]) + 1 - a[i + 1]);
    }

    if ((n - 2) % 2 == 1) {
      long sum = 0;
      for (int i = 0; i < n - 2; i += 2) {
        sum += b[i];
      }
      out.println(sum);
      return;
    }


    long[] sum1 = new long[n];
    int idx1 = 0;
    long[] sum2 = new long[n];
    int idx2 = 0;
    for (int i = 0; i < n - 2; i += 2) {
      sum1[idx1 + 1] = sum1[idx1] + b[i];
      idx1++;
    }

    for (int i = 1; i < n - 2; i += 2) {
      sum2[idx2 + 1] = sum2[idx2] + b[i];
      idx2++;
    }

    long min = Math.min(sum1[idx1], sum2[idx2]);

    for (int i = 1; i < n - 3; i += 2) {
      min = Math.min(min, sum1[i / 2 + 1] + sum2[idx2] - sum2[(i + 1) / 2]);
    }
    out.println(min);

  }
}
