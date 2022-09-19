package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMonoblock {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    long sum = 0;

    for (int i = 0; i < n; i++) {
      if (a[i] != a[i + 1]) {
        sum += (long) (i + 1) * (n - i);
      } else {
        sum += (i + 1);
      }
    }


    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      sum += add(a, x - 1, y);
      out.println(sum);
      a[x - 1] = y;
    }
  }

  private long add(int[] a, int i, int v) {
    long res = 0;
    if (i > 0) {
      if (a[i] == a[i - 1] && a[i - 1] != v) {
        res += (long) i * (n - i);
      }
      if (a[i] != a[i - 1] && a[i - 1] == v) {
        res -= (long) i * (n - i);
      }
    }
    if (i < n - 1) {
      if (a[i] == a[i + 1] && a[i + 1] != v) {
        res += (long) (i + 1) * (n - i - 1);
      }
      if (a[i] != a[i + 1] && a[i + 1] == v) {
        res -= (long) (i + 1) * (n - i - 1);
      }
    }
    return res;
  }
}
