package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTheThirdProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] pos = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      pos[a[i]] = i;
    }
    int l = n;
    int r = 0;
    long res = 1;
    int mod = (int) (1e9 + 7);
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (pos[i] >= l && pos[i] <= r) {
        res = res * (r - l - i + 1) % mod;
        cnt++;
      }
      l = Math.min(l, pos[i]);
      r = Math.max(r, pos[i]);
    }
    out.println(res);
  }
}
