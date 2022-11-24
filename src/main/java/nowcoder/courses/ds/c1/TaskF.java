package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskF {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n + 1][10];

    for (int i = 0; i < 10; i++) {
      a[0][i] = i;
    }
    for (int i = 1; i <= n; i++) {
      System.arraycopy(a[i - 1], 0, a[i], 0, 10);
      int l = in.nextInt();
      int r = in.nextInt();

      int t = a[i][l];
      a[i][l] = a[i][r];
      a[i][r] = t;
    }

    int[] pos = new int[10];
    for (int i = 0; i < m; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      for (int j = 0; j < 10; j++) {
        pos[a[l - 1][j]] = j;
      }
      for (int j = 0; j < 10; j++) {
        out.print(pos[a[r][j]], "");
      }
      out.println();
    }
  }
}
