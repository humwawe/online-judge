package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DGrid00100 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[][] res = new int[n][n];
    int col = 0;
    int cnt = 0;
    f:
    while (k > 0) {
      int i = 0;
      int j = col++;
      for (int l = 0; l < n; l++) {
        res[i][j] = 1;
        cnt++;
        if (cnt == k) {
          break f;
        }
        i++;
        j++;
        if (j >= n) {
          j -= n;
        }
      }
    }
    if (k % n != 0) {
      out.println(2);
    } else {
      out.println(0);
    }
    for (int l = 0; l < n; l++) {
      for (int m = 0; m < n; m++) {
        out.print(res[l][m]);
      }
      out.println();
    }
  }
}
