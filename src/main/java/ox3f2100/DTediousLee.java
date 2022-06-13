package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTediousLee {
  int mod = (int) (1e9 + 7);
  int N = (int) (2e6 + 9);
  int[] f = new int[N];

  {
    f[3] = 4;
    for (int i = 4; i < N; i++) {
      f[i] = (f[i - 1] + 2 * f[i - 2] % mod) % mod;
      if (i % 3 == 0) {
        f[i] = (f[i] + 4) % mod;
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    out.println(f[n]);
  }
}
