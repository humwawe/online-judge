package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CWonderfulRandomizedSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    int[] csum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      csum[i + 1] = csum[i] + a[i];
      sum += a[i];
    }
    int max = (int) -1e9;

    int min = 0;

    for (int i = 1; i <= n; i++) {
      min = Math.min(min, csum[i]);
      max = Math.max(max, 2 * csum[i] - 2 * min - sum);
    }
    out.println(max);
  }
}
