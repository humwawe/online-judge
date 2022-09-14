package best.coder.o2022.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Task3 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int len = 0;
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || a[i] != a[i - 1]) {
        a[len++] = a[i];
      }
    }

    int x = 0;
    int y = (int) (1e9 + 5);

    for (int i = 0; i < len; i++) {
      if (a[i] == x || a[i] == y) {
        continue;
      }

      if (a[i] < x && a[i] > y) {
        out.println("no");
        return;
      }

      if (a[i] > x && a[i] < y) {
        if (i == len - 1) {
          continue;
        }

        if (a[i + 1] > a[i]) {
          x = a[i];
        } else {
          y = a[i];
        }

      } else if (a[i] > x) {
        x = a[i];
      } else {
        y = a[i];
      }
    }
    out.println("yes");

  }
}
