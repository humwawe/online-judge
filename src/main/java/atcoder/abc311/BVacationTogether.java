package atcoder.abc311;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BVacationTogether {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int d = in.nextInt();
    int[][] a = new int[n][d];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < d; j++) {
        char c = in.nextCharacter();
        if (c == 'o') {
          a[i][j] = 0;
        } else {
          a[i][j] = 1;
        }
      }
    }

    int[] day = new int[d];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < d; j++) {
        if (a[i][j] == 1) {
          day[j] = 1;
        }
      }
    }
    int res = 0;
    f:
    for (int i = 0; i < d; i++) {
      if (day[i] == 1) {
        continue;
      }
      res = Math.max(res, 1);
      for (int j = i + 1; j < d; j++) {
        if (day[j] == 1) {
          continue f;
        }
        res = Math.max(res, j - i + 1);
      }
    }
    out.println(res);
  }
}
