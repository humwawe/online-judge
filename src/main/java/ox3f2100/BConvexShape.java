package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BConvexShape {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] c = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char x = in.nextCharacter();
        if (x == 'B') {
          c[i][j] = 1;
        }
      }
    }

    int[][] a = new int[n + 1][m + 1];
    int[][] b = new int[m + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        a[i][j] = a[i][j - 1] + c[i - 1][j - 1];
      }
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        b[i][j] = b[i][j - 1] + c[j - 1][i - 1];
      }
    }

    for (int i1 = 1; i1 <= n; i1++) {
      for (int j1 = 1; j1 <= m; j1++) {
        for (int i2 = 1; i2 <= n; i2++) {
          for (int j2 = 1; j2 <= m; j2++) {
            if (c[i1 - 1][j1 - 1] == 1 && c[i2 - 1][j2 - 1] == 1) {
              if ((a[i1][j2] - a[i1][j1 - 1] + b[j2][i2] - b[j2][i1 - 1] != i2 - i1 + 1 + j2 - j1 + 1) && (a[i2][j2] - a[i2][j1 - 1] + b[j1][i2] - b[j1][i1 - 1] != i2 - i1 + 1 + j2 - j1 + 1)) {
                out.println("NO");
                return;
              }
            }
          }
        }
      }
    }

    out.println("YES");
  }


}
