package atcoder.abc278;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EGridFilling {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int r = in.nextInt();
    int c = in.nextInt();
    int n = in.nextInt();
    int h = in.nextInt();
    int w = in.nextInt();
    int[][] a = new int[r][c];
    int[][] res = new int[r - h + 1][c - w + 1];
    int[] cnt = new int[n];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        a[i][j] = in.nextInt() - 1;
        cnt[a[i][j]]++;
      }
    }

    int[] tmp = new int[n];
    System.arraycopy(cnt, 0, tmp, 0, n);

    for (int i = 0; i <= r - h; i++) {

      System.arraycopy(tmp, 0, cnt, 0, n);

      for (int j = i; j < i + h; j++) {
        for (int k = 0; k < w; k++) {
          cnt[a[j][k]]--;
        }
      }

      for (int j = 0; j < c - w; j++) {

        for (int k = 0; k < n; k++) {
          if (cnt[k] > 0) {
            res[i][j]++;
          }
        }

        for (int k = i; k < i + h; k++) {
          cnt[a[k][j]]++;
        }

        for (int k = i; k < i + h; k++) {
          cnt[a[k][j + w]]--;
        }

      }
      for (int k = 0; k < n; k++) {
        if (cnt[k] > 0) {
          res[i][c - w]++;
        }
      }

    }

    for (int i = 0; i < res.length; i++) {
      out.println(res[i]);
    }

  }
}
