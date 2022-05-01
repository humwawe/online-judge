package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DNProblemsDuringKDays {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    if ((long) (k + 1) * k / 2 > n) {
      out.println("NO");
      return;
    }
    long[] a = new long[k + 1];
    long sum = (long) (k + 1) * k / 2;
    long d = (n - sum) / k;
    for (int i = 1; i <= k; i++) {
      a[i] = i + d;
    }
    long last = n - sum - d * k;
    while (last > 0) {
      for (int i = k; last > 0 && i >= 1; i--) {
        if (a[i] + 1 <= 2 * a[i - 1]) {
          a[i]++;
          last--;
        }
      }
      if (last > 0) {
        if (a[k] + 1 > 2 * a[k - 1]) {
          out.println("NO");
          return;
        }
      }
    }

    out.println("YES");
    for (int i = 1; i <= k; i++) {
      out.print(a[i], "");
    }
  }
}
