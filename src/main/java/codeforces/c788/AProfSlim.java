package codeforces.c788;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AProfSlim {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] < 0) {
        cnt++;
        a[i] = -a[i];
      }
    }
    for (int i = 0; i < cnt; i++) {
      a[i] = -a[i];
    }
    for (int i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");

  }
}
