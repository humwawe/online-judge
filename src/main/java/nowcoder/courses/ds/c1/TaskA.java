package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    long[] sum = new long[n + 1];
    sum[0] = 1;
    int mod = (int) (1e9 + 7);
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] * a[i] % mod;
    }
    CombinationMath.initMod((int) 1e9 + 7);
    for (int i = 0; i < m; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      out.println(sum[r] * CombinationMath.inv(sum[l - 1]) % mod);
    }
  }
}
