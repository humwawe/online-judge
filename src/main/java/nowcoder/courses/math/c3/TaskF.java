package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;


public class TaskF {
  int a, b;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    a = in.nextInt();
    b = in.nextInt();
    int n = in.nextInt();
    long res = 0;
    int mod = (int) (1e9 + 7);
    CombinationMath.initMod(mod);
    for (int i = 0; i <= n; i++) {
      int cnt1 = i;
      int cnt2 = n - cnt1;
      long cur = a * cnt1 + b * cnt2;
      if (check(cur)) {
        res = (res + CombinationMath.comb(n, i)) % mod;
      }
    }
    out.println(res);
  }

  private boolean check(long cur) {
    while (cur > 0) {
      long x = cur % 10;
      if (x != a && x != b) {
        return false;
      }
      cur /= 10;
    }
    return true;
  }

}
