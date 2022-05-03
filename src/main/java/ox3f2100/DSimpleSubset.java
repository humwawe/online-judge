package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DSimpleSubset {
  int N = (int) (2e6 + 5);
  boolean[] vis = new boolean[N + 1];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    getPrimes(N);
    int n = in.nextInt();
    int[] a = new int[n];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == 1) {
        cnt++;
      }
    }
    if (cnt >= 2) {
      for (int i = 0; i < n; i++) {
        if (a[i] != 1 && !vis[a[i] + 1]) {
          out.println(cnt + 1);
          out.print("1 ".repeat(cnt));
          out.println(a[i]);
          return;
        }
      }
      out.println(cnt);
      out.println("1 ".repeat(cnt));
    } else {
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (!vis[a[i] + a[j]]) {
            out.println(2);
            out.println(a[i], a[j]);
            return;
          }
        }
      }
      out.println(1);
      out.println(a[0]);
    }

  }

  void getPrimes(int n) {
    for (int i = 2; i <= n; i++) {
      if (vis[i]) {
        continue;
      }
      for (int j = i + i; j <= n; j += i) {
        vis[j] = true;
      }
    }
  }
}
