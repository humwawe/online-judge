package nowcoder.cc106;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class TaskF {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    if (n == 1) {
      out.println(1);
      return;
    }
    int mod = 998244353;
    CombinationMath.initMod(mod);
    out.println((1 + (n - 2) * CombinationMath.inv(4) % mod) % mod);

  }
}
