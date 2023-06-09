package nowcoder.b74;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.DJSet;

public class TaskF {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[m][3];
    int l = 0;
    int r = (int) 1e9;
    for (int i = 0; i < m; i++) {
      a[i][0] = in.nextInt() - 1;
      a[i][1] = in.nextInt() - 1;
      a[i][2] = in.nextInt();
    }
    int k = in.nextInt();
    int[][] b = new int[k][];
    for (int i = 0; i < k; i++) {
      int s = in.nextInt();
      b[i] = new int[s];
      for (int j = 0; j < s; j++) {
        b[i][j] = in.nextInt() - 1;
      }
    }

    while (l < r) {
      int mid = l + r >> 1;
      DJSet djSet = new DJSet(n);

      for (int i = 0; i < m; i++) {
        if (a[i][2] <= mid) {
          djSet.unite(a[i][0], a[i][1]);
        }
      }

      boolean f = true;
      for (int[] ps : b) {
        for (int i = 0; i < ps.length - 1; i++) {
          if (!djSet.equiv(ps[i], ps[i + 1])) {
            f = false;
            break;
          }
        }
      }

      if (f) {
        r = mid;
      } else {
        l = mid + 1;
      }

    }
    out.println(l);
  }
}
