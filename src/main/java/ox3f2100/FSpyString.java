package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class FSpyString {
  int n, m;
  String[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextString();
    }

    for (int i = 0; i < m; i++) {
      if (check(i)) {
        for (int j = 0; j < m; j++) {
          if (j == i) {
            out.print(res);
          } else {
            out.print(a[0].charAt(j));
          }
        }
        out.println();
        return;
      }
    }
    out.println(-1);
  }

  Set<Character> set;
  char c;
  char res;

  private boolean check(int pos) {
    set = new HashSet<>();
    c = 'a';
    res = 'a';
    for (int i = 1; i < n; i++) {
      int cnt = 0;
      for (int j = 0; j < m; j++) {
        if (j == pos) {
          c = a[i].charAt(j);
        } else {
          if (a[i].charAt(j) != a[0].charAt(j)) {
            cnt++;
          }
        }
      }
      if (cnt == 1) {
        set.add(c);
        res = c;
      }
      if (cnt >= 2) {
        return false;
      }
    }
    return set.size() <= 1;
  }
}
