package best.coder.o2022.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class Task4 {
  int n, m, k, q;
  int[][] p;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    q = in.nextInt();

    p = new int[q][3];
    for (int i = 0; i < q; i++) {
      p[i][0] = in.nextInt() - 1;
      p[i][1] = in.nextInt() - 1;
      p[i][2] = in.nextInt();
    }

    Arrays.sort(p, Comparator.comparingInt(x -> x[2]));
    int l = 0;
    int r = q;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    if (l == q) {
      out.println(-1);
    } else {
      out.println(p[l][2]);
    }
  }

  private boolean check(int mid) {
    int[][] a = new int[n][m];
    for (int i = 0; i <= mid; i++) {
      a[p[i][0]][p[i][1]] = 1;
    }
    int[][] sum = twoSum(a);
    for (int i = 1; i + k - 1 <= n; i++) {
      for (int j = 1; j + k - 1 <= m; j++) {
        int x = i + k - 1;
        int y = j + k - 1;
        if (twoQuery(sum, i, j, x, y) == k * k) {
          return true;
        }
      }
    }
    return false;

  }

  int[][] twoSum(int[][] a) {
    int n = a.length;
    int m = a[0].length;
    int[][] sum = new int[n + 1][m + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + a[i][j];
      }
    }
    return sum;
  }

  int twoQuery(int[][] sum, int x1, int y1, int x2, int y2) {
    return sum[x2][y2] + sum[x1 - 1][y1 - 1] - sum[x1 - 1][y2] - sum[x2][y1 - 1];
  }
}
