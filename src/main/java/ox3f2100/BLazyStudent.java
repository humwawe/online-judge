package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BLazyStudent {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[m][3];
    for (int i = 0; i < m; i++) {
      a[i][0] = i;
      a[i][1] = in.nextInt();
      a[i][2] = in.nextInt();
    }

    Arrays.sort(a, (x, y) -> {
      int d = x[1] - y[1];
      if (d == 0) {
        return y[2] - x[2];
      }
      return d;
    });

    int from = 2;
    int to = 3;
    int cur = 2;
    int[][] res = new int[m][2];
    for (int i = 0; i < m; i++) {
      if (a[i][2] == 1) {
        res[a[i][0]][0] = 1;
        res[a[i][0]][1] = cur;
        cur++;
      } else {
        if (to >= cur) {
          out.println(-1);
          return;
        }
        res[a[i][0]][0] = from;
        res[a[i][0]][1] = to;
        from++;
        if (from == to) {
          to++;
          from = 2;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      out.println(res[i][0], res[i][1]);
    }
  }
}
