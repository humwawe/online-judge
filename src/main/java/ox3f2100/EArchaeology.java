package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EArchaeology {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    boolean[] vis = new boolean[len];
    int l = 0;
    int r = len - 1;

    while (l < r) {
      if (s.charAt(l) == s.charAt(r)) {
        vis[l] = true;
        vis[r] = true;
        l++;
        r--;
      } else if (s.charAt(l + 1) == s.charAt(r)) {
        vis[l + 1] = true;
        vis[r] = true;
        l = l + 2;
        r--;
      } else if (s.charAt(l) == s.charAt(r - 1)) {
        vis[l] = true;
        vis[r - 1] = true;
        l++;
        r = r - 2;
      } else {
        l++;
        r--;
      }
    }
    if (l == r) {
      vis[l] = true;
    }

    for (int i = 0; i < len; i++) {
      if (vis[i]) {
        out.print(s.charAt(i));
      }
    }
    out.println();

  }
}
