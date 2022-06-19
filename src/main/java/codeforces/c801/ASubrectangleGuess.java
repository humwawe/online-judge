package codeforces.c801;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ASubrectangleGuess {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    int max = Integer.MIN_VALUE;
    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
        if (a[i][j] > max) {
          max = a[i][j];
          x = i;
          y = j;
        }
      }
    }

    int res = 0;
    res = Math.max(res, (x + 1) * (y + 1));
    res = Math.max(res, (x + 1) * (m - y));
    res = Math.max(res, (n - x) * (y + 1));
    res = Math.max(res, (n - x) * (m - y));
    out.println(res);
  }
}
