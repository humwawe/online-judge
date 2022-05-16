package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BSuspects {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int[] x = new int[n + 1];
    int[] y = new int[n + 1];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      char sign = in.nextCharacter();
      if (sign == '+') {
        a[i] = in.nextInt();
      } else {
        a[i] = -in.nextInt();
      }
      if (a[i] > 0) {
        x[a[i]]++;
      } else {
        y[-a[i]]++;
        cnt++;
      }
    }

    boolean[] st = new boolean[n + 1];
    int can = 0;
    for (int i = 1; i <= n; i++) {
      if (cnt + x[i] - y[i] == m) {
        st[i] = true;
        can++;
      }
    }

    for (int i = 0; i < n; i++) {
      if (a[i] > 0) {
        if (!st[a[i]]) {
          out.println("Lie");
          continue;
        }
        if (can < 2) {
          out.println("Truth");
          continue;
        }
      } else {
        if (!st[-a[i]]) {
          out.println("Truth");
          continue;
        }
        if (can < 2) {
          out.println("Lie");
          continue;
        }
      }
      out.println("Not defined");

    }

  }
}
