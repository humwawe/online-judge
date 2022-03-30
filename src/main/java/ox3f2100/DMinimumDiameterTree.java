package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DMinimumDiameterTree {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    double s = in.nextDouble();
    int[] deg = new int[n + 1];
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      deg[a]++;
      deg[b]++;
    }
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 1) {
        cnt++;
      }
    }
    out.println(2 * s / cnt);
  }
}
