package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CLittleArtemAndDance {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long p = 0;
    long q = 1;
    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      if (t == 1) {
        int x = in.nextInt();
        p += x;
        q += x;
      } else {
        p ^= 1;
        q ^= 1;
      }
    }
    int[] a = new int[n];
    p = (p % n + n) % n;

    for (int i = 0; i < n; i += 2) {
      a[(int) ((i + p) % n)] = i + 1;
    }
    q = (q % n + n) % n;
    for (int i = 0; i < n; i += 2) {
      a[(int) ((i + q) % n)] = i + 2;
    }
    for (int i = 0; i < n; i++) {
      out.print(a[i], "");
    }
  }
}
