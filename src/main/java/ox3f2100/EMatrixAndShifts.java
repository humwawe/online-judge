package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EMatrixAndShifts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] left = new int[n + 1];
    int[] right = new int[n + 1];
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextCharacter() - '0';
      }
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 1) {
          int t = j - i;
          if (t < 0) {
            left[n + t]++;
            right[-t]++;
          } else {
            left[t]++;
            right[n - t]++;
          }
          cnt++;
        }
      }
    }
    int c = 0;
    for (int i = 0; i <= n; i++) {
      c = Math.max(left[i], c);
      c = Math.max(right[i], c);
    }
    out.println(cnt - c + n - c);
  }
}
