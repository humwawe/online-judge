package nowcoder.c61;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int N = (int) (1e5 + 5);
    int[] cnt = new int[N];
    if (n == 1) {
      out.println(0);
      return;
    }
    int mod = (int) (1e9 + 7);
    long res = 1;
    for (int i = 1; i <= n; i++) {
      cnt[a[i - 1]]++;
      if (i == 2) {
        continue;
      }
      res *= i;
      res %= mod;
    }
    long t = CombinationMath.comb(n, 2);
    for (int i = 1; i < N; i++) {
      if (cnt[i] > 1) {
        t -= CombinationMath.comb(cnt[i], 2);
        t = CombinationMath.mod(t);
      }
    }

    out.println(res * t % mod);
  }
}
