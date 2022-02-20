package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPrimitivePrimes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int p = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] % p != 0) {
        res += i;
        break;
      }
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt();
    }
    for (int i = 0; i < m; i++) {
      if (b[i] % p != 0) {
        res += i;
        break;
      }
    }
    out.println(res);
  }
}
