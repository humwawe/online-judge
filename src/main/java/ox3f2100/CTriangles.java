package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CTriangles {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    int[][] fir = new int[10][4];
    for (int i = 0; i < 10; i++) {
      Arrays.fill(fir[i], -1);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextCharacter() - '0';
        if (fir[a[i][j]][0] == -1) {
          fir[a[i][j]][0] = i;
        }

        fir[a[i][j]][3] = i;
      }
    }
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < n; i++) {
        if (fir[a[i][j]][1] == -1) {
          fir[a[i][j]][1] = j;
        }
        fir[a[i][j]][2] = j;
      }
    }
    int[] res = new int[10];
    for (int i = 0; i < 10; i++) {
      for (int j = fir[i][0] + 1; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (a[j][k] == i) {
            int max = Math.max(k, n - 1 - k);
            res[i] = Math.max(res[i], max * (j - fir[i][0]));
          }
        }
      }
    }
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < fir[i][3]; j++) {
        for (int k = 0; k < n; k++) {
          if (a[j][k] == i) {
            int max = Math.max(k, n - 1 - k);
            res[i] = Math.max(res[i], max * (fir[i][3] - j));
          }
        }
      }
    }
    for (int i = 0; i < 10; i++) {
      for (int k = fir[i][1] + 1; k < n; k++) {
        for (int j = 0; j < n; j++) {
          if (a[j][k] == i) {
            int max = Math.max(j, n - 1 - j);
            res[i] = Math.max(res[i], max * (k - fir[i][1]));
          }
        }
      }
    }
    for (int i = 0; i < 10; i++) {
      for (int k = 0; k < fir[i][2]; k++) {
        for (int j = 0; j < n; j++) {
          if (a[j][k] == i) {
            int max = Math.max(j, n - 1 - j);
            res[i] = Math.max(res[i], max * (fir[i][2] - k));
          }
        }
      }
    }
    out.println(res);
  }
}
