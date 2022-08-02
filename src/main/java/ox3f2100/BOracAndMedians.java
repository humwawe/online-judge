package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BOracAndMedians {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    boolean f = false;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == k) {
        f = true;
      }
    }
    if (!f) {
      out.println("no");
      return;
    }
    if (n == 1) {
      out.println("yes");
      return;
    }

    for (int i = 0; i + 1 < n; i++) {
      if (a[i] >= k && a[i + 1] >= k) {
        out.println("yes");
        return;
      }
    }
    for (int i = 0; i + 2 < n; i++) {
      if (a[i] >= k && a[i + 2] >= k) {
        out.println("yes");
        return;
      }
    }
    out.println("no");

  }
}
