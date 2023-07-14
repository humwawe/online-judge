package nowcoder.c76;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int f = 0;
    long res = 0;
    int mod = 998244353;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (f == 0) {
        res = (res + x) % mod;
        if (x > 0) {
          if (x == 1) {
            f = 1;
          } else {
            f = 2;
          }

        }
      } else if (f == 1) {
        if (x != 0) {
          res = (res + x) % mod;
          f = 2;
        }
      } else {
        if (x == 1) {
          res = (res + 1) % mod;
        } else if (x != 0) {
          res = (res * x) % mod;
        }
      }
    }
    out.println(res);
  }
}
