package ccf.csp.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][4];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
      a[i][2] = in.nextInt();
      a[i][3] = in.nextInt();
    }

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(i);
    }

    for (int i = 0; i < m; i++) {
      int cur = -1;
      int x = in.nextInt();
      int y = in.nextInt();
      for (int ii = 0; ii < n; ii++) {
        int j = list.get(ii);
        if (a[j][0] <= x && x <= a[j][2] && a[j][1] <= y && y <= a[j][3]) {
          cur = j;
        }
      }
      if (cur == -1) {
        out.println("IGNORED");
      } else {
        for (int j = 0; j < n; j++) {
          if (list.get(j) == cur) {
            list.remove(j);
            break;
          }
        }
        list.add(cur);
        out.println(cur + 1);
      }
    }
  }
}
