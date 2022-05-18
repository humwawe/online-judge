package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DDividingIsland {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();
    int n = in.nextInt();
    int[][] g = new int[105][105];
    for (int i = 1; i <= a; i++) {
      for (int j = 1; j <= b; j++) {
        g[i][j] = 1;
      }
    }
    for (int i = a + 1; i <= a + c; i++) {
      for (int j = 1; j <= d; j++) {
        g[i][j] = 1;
      }
    }
    int x = 0;
    int y = 0;
    int dir = 0;
    if (b > d) {
      if (d % 2 == 1) {
        x = a + c;
        y = 1;
        dir = -1;
      } else {
        x = 1;
        y = 1;
        dir = 1;
      }
    } else {
      if (b % 2 == 1) {
        x = 1;
        y = 1;
        dir = 1;
      } else {
        x = a + c;
        y = 1;
        dir = -1;
      }
    }
    char[][] res = new char[105][105];
    for (int i = 0; i < 105; i++) {
      Arrays.fill(res[i], '.');
    }
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      while (t-- > 0) {
        res[x][y] = (char) ('a' + i);
        x += dir;
        if (g[x][y] == 0) {
          x -= dir;
          y++;
          dir = -dir;
        }
      }
    }

    out.println("YES");
    for (int i = 1; i <= Math.max(b, d); i++) {
      for (int j = 1; j <= a + c; j++) {
        out.print(res[j][i]);
      }
      out.println();
    }
  }
}
