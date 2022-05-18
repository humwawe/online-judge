package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ABlackAndWhiteCube {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n % 2 == 1) {
      out.println(-1);
      return;
    }

    int[][] res = new int[n][n];
    int i = 0;
    int j = n - 1;

    int s = 0;
    while (i < j) {
      for (int k = i; k <= j; k++) {
        res[i][k] = s;
        res[j][k] = s;
        res[k][i] = s;
        res[k][j] = s;
      }
      i++;
      j--;
      s = 1 - s;
    }
    char[] can = new char[]{'w', 'b'};
    for (int k = 0; k < n; k++) {
      for (int l = 0; l < n; l++) {
        for (int m = 0; m < n; m++) {
          out.print(k % 2 == 0 ? can[res[l][m]] : can[1 - res[l][m]]);
        }
        out.println();
      }
      out.println();
    }

  }
}
