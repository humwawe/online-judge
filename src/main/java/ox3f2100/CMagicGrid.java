package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMagicGrid {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] res = new int[n][n];
    int fill = 0;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        res[i][j] = 4 * fill;
        res[i][j + n / 2] = 4 * fill + 1;
        res[i + n / 2][j] = 4 * fill + 2;
        res[i + n / 2][j + n / 2] = 4 * fill + 3;
        fill++;
      }
    }
    for (int i = 0; i < n; i++) {
      out.println(res[i]);
    }
  }
}
