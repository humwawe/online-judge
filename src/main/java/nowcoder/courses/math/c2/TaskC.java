package nowcoder.courses.math.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;
import util.MathMeth;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int k = in.nextInt();
    int len = (n + 1) / k;
    String s = in.nextString();
    long[] pa = new long[k];
    long[] pb = new long[k];
    int mod = (int) (1e9 + 9);

    CombinationMath.initMod(mod);
    pa[0] = CombinationMath.pow(a, n - k + 1);
    pb[0] = 1;
    for (int i = 1; i < k; i++) {
      pa[i] = pa[i - 1] * a % mod;
      pb[i] = pb[i - 1] * b % mod;
    }

    long sum = 0;
    for (int i = 0; i < k; i++) {
      int t = 1;
      if (s.charAt(i) == '-') {
        t = -1;
      }
      sum = (mod + sum + t * pa[k - 1 - i] * pb[i] % mod) % mod;
    }
    long akn = CombinationMath.inv(CombinationMath.pow(a, k));
    long bk = pb[k - 1] * b % mod;
    long t = akn * bk % mod;

    out.println(MathMeth.geometricSum(sum, t, len, mod));


    //    if (t == 1) {
    //      out.println(sum * len % mod);
    //    } else {
    //
    //      out.println(sum * ((mod + 1 - CombinationMath.pow(t, len)) % mod) % mod * CombinationMath.inv((mod + 1 - t) % mod) % mod);
    //    }
  }


}
