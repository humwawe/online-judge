package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAnyaAndSmartphone {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n + 1];
    int[] idx = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      idx[a[i]] = i;
    }
    long res = 0;
    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      int t = idx[x];
      res += (t + k - 1) / k;
      if (t - 1 <= 0) {
        continue;
      }
      int tmp = a[t - 1];
      a[t - 1] = a[t];
      a[t] = tmp;
      idx[a[t - 1]] = t - 1;
      idx[a[t]] = t;
    }
    out.println(res);
  }
}
