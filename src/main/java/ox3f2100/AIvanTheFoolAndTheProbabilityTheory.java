package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AIvanTheFoolAndTheProbabilityTheory {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] f = new int[Math.max(n, m) + 5];
    f[1] = 2;
    f[2] = 4;
    int mod = (int) (1e9 + 7);
    for (int i = 3; i < f.length; i++) {
      f[i] = (f[i - 1] + f[i - 2]) % mod;
    }

    out.println((f[n] + f[m] - 2) % mod);
  }
}
