package codeforces.c809;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AAnotherStringMinimizationProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[] a = new char[m];
    for (int i = 0; i < m; i++) {
      a[i] = 'B';
    }
    for (int i = 0; i < n; i++) {
      int x = in.nextInt() - 1;
      int y = m - 1 - x;

      if (a[Math.min(x, y)] == 'B') {
        a[Math.min(x, y)] = 'A';
      } else {
        a[Math.max(x, y)] = 'A';
      }

    }
    for (int i = 0; i < m; i++) {
      out.print(a[i]);
    }
    out.println();

  }
}
