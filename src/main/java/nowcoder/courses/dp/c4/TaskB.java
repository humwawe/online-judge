package nowcoder.courses.dp.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
  int m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    m = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < m; j++) {
        char c = in.nextCharacter();
        if (c == 'H') {
          a[i] |= 1 << j;
        }
      }
    }

    int lim = 1 << m;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < lim; i++) {
      if (check(i)) {
        list.add(i);
      }
    }

    int[][][] dp = new int[2][lim][lim];


    for (int i = 1; i <= n; i++) {
      for (Integer x : list) {
        for (Integer y : list) {
          for (Integer z : list) {
            if ((a[i] & z) != 0 || (a[i - 1] & y) != 0) {
              continue;
            }
            if ((x & y) != 0 || (x & z) != 0 || (y & z) != 0) {
              continue;
            }
            dp[i % 2][z][y] = Math.max(dp[i % 2][z][y], dp[(i + 1) % 2][y][x] + Integer.bitCount(z));
          }
        }
      }
    }
    int res = 0;
    for (Integer x : list) {
      for (Integer y : list) {
        res = Math.max(res, dp[n % 2][x][y]);
      }
    }
    out.println(res);

  }

  private boolean check(int i) {
    for (int j = 0; j < m - 1; j++) {
      if ((i >> j & 1) == 1) {
        if ((i >> j + 1 & 1) == 1 || (i >> j + 2 & 1) == 1) {
          return false;
        }
      }
    }
    return true;
  }
}
