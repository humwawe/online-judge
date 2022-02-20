package codeforces.c763;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ARobotCleaner {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    int tx = in.nextInt();
    int ty = in.nextInt();
    int cnt = 0;
    int dn = 1;
    int dm = 1;
    while (x != tx && y != ty) {
      x += dn;
      y += dm;
      if (y > m) {
        y = m - 1;
        dm = -1;
      }
      if (x > n) {
        x = n - 1;
        dn = -1;
      }
      cnt++;
    }
    out.println(cnt);
  }
}
