package atcoder.abc308;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CStandings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[][] a = new long[n][2];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = a[i][0] + in.nextInt();
    }
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }


    Arrays.sort(idx, (x, y) -> {
      long d = a[x][0] * a[y][1] - a[x][1] * a[y][0];
      if (d == 0) {
        return x - y;
      }
      if (d > 0) {
        return -1;
      } else {
        return 1;
      }
    });

    for (int i = 0; i < n; i++) {
      out.print(idx[i] + 1, "");
    }

  }
}
