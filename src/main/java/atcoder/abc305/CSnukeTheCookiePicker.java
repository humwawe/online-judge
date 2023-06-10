package atcoder.abc305;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CSnukeTheCookiePicker {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] mat = new char[n][m];
    int a = 505, b = 0, c = 505, d = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = in.nextCharacter();
        if (mat[i][j] == '#') {
          a = Math.min(a, i);
          b = Math.max(b, i);
          c = Math.min(c, j);
          d = Math.max(d, j);
        }
      }
    }
    for (int i = a; i <= b; i++) {
      for (int j = c; j <= d; j++) {
        if (mat[i][j] == '.') {
          out.println(i + 1, j + 1);
          return;
        }
      }
    }
  }
}
