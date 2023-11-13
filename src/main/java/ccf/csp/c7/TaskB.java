package ccf.csp.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[][] a = new int[15][10];
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 10; j++) {
        a[i][j] = in.nextInt();
      }
    }

    int[][] b = new int[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        b[i][j] = in.nextInt();
      }
    }

    int j = in.nextInt() - 1;

    for (int i = 0; i <= 15; i++) {
      if (!check(i, j, a, b)) {
        draw(i - 1, j, a, b);
        break;
      }
    }

    for (int i = 0; i < 15; i++) {
      out.println(a[i]);
    }

  }

  private void draw(int i, int j, int[][] a, int[][] b) {
    for (int k = i; k < i + 4 && k < 15; k++) {
      for (int l = j; l < j + 4; l++) {
        a[k][l] = a[k][l] | b[k - i][l - j];
      }
    }
  }

  private boolean check(int i, int j, int[][] a, int[][] b) {
    for (int k = i; k < i + 4; k++) {
      for (int l = j; l < j + 4; l++) {
        if (k >= 15) {
          if (b[k - i][l - j] == 1) {
            return false;
          }
        } else if ((a[k][l] & b[k - i][l - j]) == 1) {
          return false;
        }
      }
    }
    return true;
  }
}
