package atcoder.abc278;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class FShiritori {
  int n;
  String[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextString();
    }

    if (dfs(true, 0, '#')) {
      out.println("First");
    } else {
      out.println("Second");
    }

  }

  private boolean dfs(boolean turn, int st, char last) {
    if (turn) {
      for (int i = 0; i < n; i++) {
        if (((st >> i) & 1) == 1) {
          continue;
        }
        if (last != '#' && a[i].charAt(0) != last) {
          continue;
        }
        if (dfs(!turn, st | (1 << i), a[i].charAt(a[i].length() - 1))) {
          return true;
        }
      }
      return false;
    } else {
      for (int i = 0; i < n; i++) {
        if (((st >> i) & 1) == 1) {
          continue;
        }
        if (last != '#' && a[i].charAt(0) != last) {
          continue;
        }
        if (!dfs(!turn, st | (1 << i), a[i].charAt(a[i].length() - 1))) {
          return false;
        }
      }
      return true;


    }


  }
}
