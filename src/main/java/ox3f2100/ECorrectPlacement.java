package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class ECorrectPlacement {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][3];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      a[i][0] = Math.min(x, y);
      a[i][1] = Math.max(x, y);
      a[i][2] = i + 1;
    }
    int[] res = new int[n + 1];
    Arrays.sort(a, Comparator.comparingInt(x -> x[0]));

    int idx = -1;
    int min = (int) (1e9 + 5);
    for (int i = 0; i < n; i++) {
      int j = i;
      while (j + 1 < n && a[j + 1][0] == a[i][0]) {
        j++;
      }
      int t = min;
      int tI = idx;
      for (int k = i; k <= j; k++) {
        if (a[k][1] > t) {
          res[a[k][2]] = tI;
        } else {
          res[a[k][2]] = -1;
        }
        if (a[k][1] < min) {
          min = a[k][1];
          idx = a[k][2];
        }
      }
      i = j;
    }
    for (int i = 1; i <= n; i++) {
      out.print(res[i], "");
    }
    out.println();
  }
}
