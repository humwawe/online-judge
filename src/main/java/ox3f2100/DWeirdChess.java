package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DWeirdChess {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    char[][] b = new char[n][n];
    char[][] a = new char[n * 2][n * 2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        b[i][j] = in.nextCharacter();
      }
    }
    for (int i = 0; i < 2 * n - 1; i++) {
      for (int j = 0; j < 2 * n - 1; j++) {
        a[i][j] = 'x';
      }
    }
    a[n - 1][n - 1] = 'o';
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (b[i][j] == 'o') {
          for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
              if (b[k][l] == '.') {
                a[n - 1 + k - i][n - 1 + l - j] = '.';
              }
            }
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (b[i][j] == 'x') {
          boolean good = false;
          for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
              if (b[k][l] == 'o' && a[n - 1 + i - k][n - 1 + j - l] == 'x') {
                good = true;
              }
            }
          }
          if (!good) {
            out.println("NO");
            return;
          }
        }
      }
    }


    out.println("YES");
    for (int i = 0; i < 2 * n - 1; i++) {
      for (int j = 0; j < 2 * n - 1; j++) {
        out.print(a[i][j]);
      }
      out.println();
    }
  }
}
