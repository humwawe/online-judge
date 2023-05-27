package acwing.contest.weekly.c105;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  int n, k;
  char[][] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();

    k = in.nextInt();
    a = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextCharacter();
      }
    }
    char[][] b = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        b[i][j] = a[i][j];
      }
    }
    int t = n;
    for (int c = 0; c < k - 1; c++) {
      StringBuilder[] stringBuilders = new StringBuilder[t * n];
      Arrays.setAll(stringBuilders, e -> new StringBuilder());
      for (int i = 0; i < t; i++) {
        for (int j = 0; j < t; j++) {
          if (b[i][j] == '.') {
            for (int l = 0; l < n; l++) {
              for (int m = 0; m < n; m++) {
                stringBuilders[i * n + l].append(a[l][m]);
              }
            }
          } else {
            for (int l = 0; l < n; l++) {
              for (int m = 0; m < n; m++) {
                stringBuilders[i * n + l].append('*');
              }
            }
          }
        }
      }
      t *= n;

      b = new char[t][t];
      for (int i = 0; i < t; i++) {
        for (int j = 0; j < t; j++) {
          b[i][j] = stringBuilders[i].charAt(j);
        }
      }


    }

    for (int i = 0; i < t; i++) {
      for (int j = 0; j < t; j++) {
        out.print(b[i][j]);
      }
      out.println();
    }

  }


}
