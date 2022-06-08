package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DZigzags {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int[][] sum = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        sum[i][j] = sum[i - 1][j];
      }
      sum[i][a[i]]++;
    }
    long res = 0;
    for (int i = 2; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        res += (long) sum[i - 1][a[j]] * (sum[n][a[i]] - sum[j][a[i]]);
      }
    }
    out.println(res);
  }
}
