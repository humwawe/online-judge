package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DVasyaAndTheMatrix {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int x = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      x ^= a[i];
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt();
      x ^= b[i];
    }
    if (x != 0) {
      out.println("NO");
      return;
    }

    int[][] res = new int[n][m];
    res[0][0] = a[0];
    for (int i = 1; i < m; i++) {
      res[0][0] ^= b[i];
      res[0][i] = b[i];
    }
    for (int i = 1; i < n; i++) {
      res[i][0] = a[i];
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      out.println(res[i]);
    }
  }
}
