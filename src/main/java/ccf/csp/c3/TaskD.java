package ccf.csp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.DJSet;

import java.util.Arrays;
import java.util.Comparator;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[m][3];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < 3; j++) {
        a[i][j] = in.nextInt();
      }
    }

    Arrays.sort(a, Comparator.comparingInt(x -> x[2]));

    DJSet djSet = new DJSet(n);

    int res = 0;
    for (int i = 0; i < m; i++) {
      int x = a[i][0] - 1;
      int y = a[i][1] - 1;
      if (!djSet.equiv(x, y)) {
        res += a[i][2];
        djSet.unite(x, y);
      }
    }

    out.println(res);

  }


}
