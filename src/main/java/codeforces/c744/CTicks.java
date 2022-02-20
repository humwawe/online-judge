package codeforces.c744;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTicks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    char[][] mat = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = in.nextCharacter();
      }
    }
    int[][] num = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int h = 0;
        if (mat[i][j] == '*') {
          while (i - h >= 0 && j - h >= 0 && j + h < m && mat[i - h][j - h] == mat[i - h][j + h] && mat[i - h][j - h] == '*') {
            h++;
          }
        }
        int tmp = h - 1;
        while (tmp >= 0) {
          num[i - tmp][j - tmp] = Math.max(num[i - tmp][j - tmp], h - 1);
          num[i - tmp][j + tmp] = Math.max(num[i - tmp][j + tmp], h - 1);
          tmp--;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == '*' && num[i][j] < k) {
          out.println("NO");
          return;
        }
      }
    }
    out.println("YES");

  }
}
