package codeforces.c874;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CVladBuildingBeautifulArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int inf = (int) (1e9 + 5);
    int c1 = inf, c2 = inf;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] % 2 == 1) {
        c1 = Math.min(c1, a[i]);
      } else {
        c2 = Math.min(c2, a[i]);
      }
    }
    boolean f = true;
    for (int i = 0; i < n; i++) {
      if (a[i] % 2 == 0) {
        continue;
      }
      if (a[i] - c1 > 0) {
        continue;
      }
      f = false;
      break;
    }
    if (!f) {
      for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 1) {
          continue;
        }
        if (a[i] - c1 > 0) {
          continue;
        }
        out.println("NO");
        return;
      }

    }
    out.println("YES");


  }
}
