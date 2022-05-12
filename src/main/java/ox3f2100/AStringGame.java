package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AStringGame {
  String s, t;
  int n;
  boolean[] vis;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    n = s.length();
    t = in.nextString();
    int[] a = new int[n];
    vis = new boolean[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int l = 0;
    int r = n - 1;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      for (int i = 0; i < mid; i++) {
        vis[a[i] - 1] = true;
      }
      if (check()) {
        l = mid;
      } else {
        r = mid - 1;
      }
      for (int i = 0; i < mid; i++) {
        vis[a[i] - 1] = false;
      }
    }
    out.println(l);
  }

  private boolean check() {
    int i = 0;
    int j = 0;
    while (i < n && j < t.length()) {
      if (vis[i]) {
        i++;
        continue;
      }
      if (s.charAt(i) == t.charAt(j)) {
        j++;
      }
      i++;
    }
    return j == t.length();
  }
}
