package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DConstantPalindromeSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] sum = new int[2 * k + 2];
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    for (int i = 0; i < n / 2; i++) {
      int x = a[i];
      int y = a[n - i - 1];

      int mid = x + y;
      int min = Math.min(x, y) + 1;
      int max = Math.max(x, y) + k;
      sum[2] += 2;
      sum[min] -= 2;

      sum[min] += 1;
      sum[mid] -= 1;

      sum[mid + 1] += 1;
      sum[max + 1] -= 1;

      sum[max + 1] += 2;
      sum[2 * k + 1] -= 2;
    }
    int res = (int) 1e8;
    for (int i = 2; i <= 2 * k; i++) {
      sum[i] += sum[i - 1];
      res = Math.min(res, sum[i]);
    }
    out.println(res);
  }
}
