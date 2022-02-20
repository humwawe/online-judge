package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BDimaAndABadXOR {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Integer> list = new ArrayList<>();
    boolean flag = false;
    int line = 0;
    int idx = 0;
    for (int i = 0; i < n; i++) {
      int[] a = new int[n];
      for (int j = 0; j < m; j++) {
        a[j] = in.nextInt();
      }
      list.add(a[0]);
      if (flag) {
        continue;
      }
      for (int j = 1; j < m; j++) {
        if (a[0] != a[j]) {
          flag = true;
          line = i;
          idx = j;
          break;
        }
      }
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      res = res ^ list.get(i);
    }
    if (res == 0 && !flag) {
      out.println("NIE");
    } else {
      out.println("TAK");
      if (res != 0) {
        for (int i = 0; i < n; i++) {
          out.println("1 ");
        }
      } else {
        for (int i = 0; i < n; i++) {
          if (i == line) {
            out.println(idx + 1 + " ");
          } else {
            out.println("1 ");
          }
        }
      }
    }

  }
}
