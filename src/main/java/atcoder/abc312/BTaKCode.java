package atcoder.abc312;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BTaKCode {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }

    for (int i = 0; i < n - 8; i++) {
      for (int j = 0; j < m - 8; j++) {
        if (check(a, i, j)) {
          out.println(i + 1, j + 1);
        }
      }
    }
  }

  private boolean check(char[][] a, int i, int j) {
    String[] b = new String[9];
    for (int k = 0; k < 3; k++) {
      b[k] = "###.?????";
    }
    b[3] = "....?????";
    b[4] = "?????????";
    b[5] = "?????....";

    for (int k = 6; k < 9; k++) {
      b[k] = "?????.###";
    }


    for (int k = 0; k < 9; k++) {
      for (int l = 0; l < 9; l++) {
        if (b[k].charAt(l) == '?') {
          continue;
        }
        if (a[i + k][j + l] != b[k].charAt(l)) {
          return false;
        }
      }
    }

    return true;
  }
}
