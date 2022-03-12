package codeforces.c777;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMadokaAndTheElegantGift {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter() - '0';
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 1) {
          int x = j;
          while (x < m && a[i][x] == 1) {
            x++;
          }
          int y = i;
          while (y < n && a[y][j] == 1) {
            y++;
          }
          for (int k = i; k < y; k++) {
            for (int l = j; l < x; l++) {
              if (a[k][l] != 1) {
                out.println("NO");
                return;
              }
            }
          }

          if (i > 0) {
            for (int l = j; l < x; l++) {
              if (a[i - 1][l] == 1) {
                out.println("NO");
                return;
              }
            }
          }

          if (y < n) {
            for (int l = j; l < x; l++) {
              if (a[y][l] == 1) {
                out.println("NO");
                return;
              }
            }
          }


          if (j > 0) {
            for (int k = i; k < y; k++) {
              if (a[k][j - 1] == 1) {
                out.println("NO");
                return;
              }
            }
          }

          if (x < m) {
            for (int k = i; k < y; k++) {
              if (a[k][x] == 1) {
                out.println("NO");
                return;
              }
            }
          }


          for (int k = i; k < y; k++) {
            for (int l = j; l < x; l++) {
              a[k][l] = 0;
            }
          }
        }

      }
    }

    out.println("YES");
  }
}
