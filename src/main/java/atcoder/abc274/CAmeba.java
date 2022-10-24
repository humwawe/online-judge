package atcoder.abc274;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAmeba {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] p = new int[2 * n + 2];
    for (int i = 1; i <= n; i++) {
      int a = in.nextInt();
      p[i * 2] = p[i * 2 + 1] = a;
    }
    int[] res = new int[2 * n + 2];
    for (int i = 2; i < 2 * n + 2; i++) {
      res[i] = res[p[i]] + 1;
    }
    for (int i = 1; i <= 2 * n + 1; i++) {
      out.println(res[i]);
    }
  }
}
