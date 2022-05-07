package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DArtsemAndSaunders {
  int N = 100005;
  int[] a = new int[N];
  int[] b = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = 0;
    for (int i = 1; i <= n; i++) {
      int x = in.nextInt();
      if (a[x] == 0) {
        a[x] = ++m;
        b[m] = x;
        a[i] = m;
      } else if (b[a[x]] == x) {
        a[i] = a[x];
      } else {
        out.println(-1);
        return;
      }
    }

    out.println(m);
    for (int i = 1; i <= n; i++) {
      out.print(a[i], "");
    }
    out.println();
    for (int i = 1; i <= m; i++) {
      out.print(b[i], "");
    }
    out.println();

  }
}
