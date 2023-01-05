package nowcoder.courses.ab.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  int k;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    k = in.nextInt() * 2;
    int[][] a = new int[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        a[i][j] = in.nextInt();
      }
    }
    out.println(dfs(0, 0, a));
  }

  private int dfs(int cnt, int p, int[][] a) {
    if (cnt == k) {
      return 0;
    }

    if (p == 0) {
      int res = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          int cur = helper(a, i, j);
          helper2(a, i, j);
          res = Math.max(res, cur + dfs(cnt + 1, 1 - p, a));
          helper3(a, i, j);
        }
      }
      return res;
    } else {
      int res = (int) 1e8;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          int cur = helper(a, i, j);
          helper2(a, i, j);
          res = Math.min(res, cur + dfs(cnt + 1, 1 - p, a));
          helper3(a, i, j);
        }
      }
      return res;
    }
  }

  private void helper2(int[][] a, int i, int j) {
    int t = a[i][j];
    a[i][j] = a[i][j + 1];
    a[i][j + 1] = a[i + 1][j + 1];
    a[i + 1][j + 1] = a[i + 1][j];
    a[i + 1][j] = t;
  }

  private void helper3(int[][] a, int i, int j) {
    int t = a[i][j];
    a[i][j] = a[i + 1][j];
    a[i + 1][j] = a[i + 1][j + 1];
    a[i + 1][j + 1] = a[i][j + 1];
    a[i][j + 1] = t;
  }

  private int helper(int[][] a, int i, int j) {
    int res = 0;
    for (int k = i; k < i + 2; k++) {
      for (int l = j; l < j + 2; l++) {
        res += a[k][l];
      }
    }
    return res;
  }
}
