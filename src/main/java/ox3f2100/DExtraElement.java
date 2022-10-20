package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class DExtraElement {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = i + 1;
    }
    Arrays.sort(a, Comparator.comparingInt(x -> x[0]));
    if (n <= 2) {
      out.println(1);
      return;
    }

    int d = a[2][0] - a[1][0];
    boolean f = true;
    for (int i = 3; i < n; i++) {
      if (a[i][0] - a[i - 1][0] != d) {
        f = false;
        break;
      }
    }
    if (f) {
      out.println(a[0][1]);
      return;
    }

    d = a[2][0] - a[0][0];
    f = true;
    for (int i = 3; i < n; i++) {
      if (a[i][0] - a[i - 1][0] != d) {
        f = false;
        break;
      }
    }
    if (f) {
      out.println(a[1][1]);
      return;
    }

    d = a[1][0] - a[0][0];

    boolean first = true;
    int res = -1;
    for (int i = 2; i < n; i++) {
      if (a[i][0] - a[i - 1][0] != d) {
        if (first) {
          a[i][0] = a[i - 1][0];
          first = false;
          res = a[i][1];
        } else {
          out.println(-1);
          return;
        }
      }
    }
    out.println(res);
  }


}
