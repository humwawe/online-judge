package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DGraphAndItsComplement {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    if (a != 1 && b != 1) {
      out.println("NO");
      return;
    }

    if (a == 1 && b == 1) {
      if (n == 2 || n == 3) {
        out.println("NO");
        return;
      }
      out.println("YES");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (Math.abs(i - j) == 1) {
            out.print(1);
          } else {
            out.print(0);
          }
        }
        out.println();
      }
      return;
    }
    out.println("YES");
    int[][] res = new int[n][n];
    int max = Math.max(a, b);
    for (int i = max - 1; i < n; i++) {
      for (int j = max - 1; j < n; j++) {
        if (i == j) {
          continue;
        }
        res[i][j] = 1;
      }
    }

    int t = 0;
    if (a == 1) {
      t = 1;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          out.print(0);
        } else {
          out.print(res[i][j] ^ t);
        }
      }
      out.println();
    }

  }
}
