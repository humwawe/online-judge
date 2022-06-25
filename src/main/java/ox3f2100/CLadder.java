package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CLadder {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int[] r = new int[n];
    r[0] = 0;
    for (int i = 1; i < n; i++) {
      if (a[i] <= a[i - 1]) {
        r[i] = r[i - 1];
      } else {
        r[i] = i;
      }
    }

    int[] l = new int[n];
    l[n - 1] = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      if (a[i] <= a[i + 1]) {
        l[i] = l[i + 1];
      } else {
        l[i] = i;
      }
    }

    for (int i = 0; i < m; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      if (l[x] >= r[y]) {
        out.println("Yes");
      } else {
        out.println("No");
      }
    }
  }
}
