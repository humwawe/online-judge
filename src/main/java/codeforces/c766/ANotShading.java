package codeforces.c766;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ANotShading {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int r = in.nextInt() - 1;
    int c = in.nextInt() - 1;
    char[][] a = new char[n][m];
    boolean b = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
        if (a[i][j] == 'B') {
          b = true;
        }
      }
    }
    if (!b) {
      out.println(-1);
      return;
    }
    if (a[r][c] == 'B') {
      out.println(0);
      return;
    }

    b = false;
    for (int i = 0; i < m; i++) {
      if (a[r][i] == 'B') {
        b = true;
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      if (a[i][c] == 'B') {
        b = true;
        break;
      }
    }
    if (b) {
      out.println(1);
    } else {
      out.println(2);
    }

  }
}
