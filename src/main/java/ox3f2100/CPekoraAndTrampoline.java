package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPekoraAndTrampoline {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    int[] b = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }

    long res = 0;
    for (int i = 1; i <= n; i++) {
      if (b[i] < a[i] - 1) {
        res += a[i] - 1 - b[i];
      }
      if (b[i] > a[i] - 1) {
        b[i + 1] += b[i] - a[i] + 1;
      }

      for (int j = i + 2; j <= Math.min(n, i + a[i]); j++) {
        b[j] += 1;
      }

    }
    out.println(res);
  }
}
