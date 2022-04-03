package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CJamieAndInterestingGraph {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int p = 100003;
    for (int i = 2; i * i <= p; i++) {
      if (p % i == 0) {
        out.println("YES");
      }
    }
    out.println(p, p);
    for (int i = 1; i < n - 1; i++) {
      out.println(i, i + 1, 1);
    }
    out.println(n - 1, n, p - (n - 2));

    int cnt = n - 1;
    if (cnt == m) {
      return;
    }
    int lim = n;
    while (true) {
      for (int i = 1; i <= lim - 2; i++) {
        if (cnt == m) {
          return;
        }
        out.println(i, lim, (int) 1e9);
        cnt++;
      }
      if (cnt == m) {
        return;
      }
      lim--;
    }
  }
}
