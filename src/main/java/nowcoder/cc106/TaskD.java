package nowcoder.cc106;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.nextInt();
    if (n == 3) {
      out.println("111");
      out.println("010");
      out.println("000");
      return;
    }
    int[][] a = new int[n][n];

    for (int i = 0; i < n; i++) {
      a[n - 1][i] = 1;
    }

    for (int i = 0; i < n - 1; i++) {
      a[1][i] = 1;
    }

    for (int i = 1; i < n; i++) {
      a[i][0] = 1;
    }

    for (int i = 3; i < n; i++) {
      for (int j = 0; j < n; j += 2) {
        a[i][j] = 1;
      }
    }
    int o = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 1) {
          o++;
        }
      }
    }
    int z = n * n - o;
    int x = 4;
    while (Math.abs(o - z) > 1) {
      a[x][n - 1] = 0;
      o--;
      z++;
      a[x - 1][n - 2] = 1;
      a[x - 1][n - 1] = 0;
      x += 2;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(a[i][j]);
      }
      out.println();
    }
  }
}
