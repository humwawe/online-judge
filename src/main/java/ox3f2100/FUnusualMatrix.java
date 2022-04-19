package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class FUnusualMatrix {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextCharacter() - '0';
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] ^= in.nextCharacter() - '0';
      }
    }

    for (int j = 0; j < n; j++) {
      if (a[0][j] != 0) {
        for (int i = 0; i < n; i++) {
          a[i][j] ^= 1;
        }
      }
    }

    for (int i = 1; i < n; i++) {
      int res = 0;
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 0) {
          res |= 1;
        } else {
          res |= 2;
        }
      }
      if (res == 3) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }
}
