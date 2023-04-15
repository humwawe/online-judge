package atcoder.abc298;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BColoringMatrix {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    int[][] b = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        b[i][j] = in.nextInt();
      }
    }

    if (helper(a, b)) {
      out.println("Yes");
      return;
    }

    a = rotate(a);
    if (helper(a, b)) {
      out.println("Yes");
      return;
    }
    a = rotate(a);
    if (helper(a, b)) {
      out.println("Yes");
      return;
    }
    a = rotate(a);
    if (helper(a, b)) {
      out.println("Yes");
      return;
    }
    out.println("No");
  }

  private boolean helper(int[][] a, int[][] b) {
    int n = b.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 1) {
          if (b[i][j] == 0) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private int[][] rotate(int[][] a) {
    int n = a.length;
    int[][] res = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        res[i][j] = a[n - 1 - j][i];
      }
    }
    return res;
  }
}
