package ccf.csp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int x = 0;
    int y = 0;
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    boolean f = false;
    while (list.size() < n * n / 2) {
      list.add(a[x][y]);
      list2.add(a[n - 1 - x][n - 1 - y]);
      if (!f) {
        x--;
        y++;
        if (x < 0) {
          x = 0;
          f = true;
        }
      } else {
        x++;
        y--;
        if (y < 0) {
          y = 0;
          f = false;
        }
      }
    }
    for (Integer integer : list) {
      out.print(integer, "");
    }
    if (n * n % 2 == 1) {
      out.print(a[n / 2][n / 2], "");
    }

    for (int i = list2.size() - 1; i >= 0; i--) {
      out.print(list2.get(i), "");
    }
    out.println();
  }
}
