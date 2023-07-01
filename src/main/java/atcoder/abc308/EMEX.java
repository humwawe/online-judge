package atcoder.abc308;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EMEX {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    char[] s = in.nextString().toCharArray();
    int[][] suf = new int[n + 1][3];
    for (int i = n - 1; i >= 0; i--) {
      System.arraycopy(suf[i + 1], 0, suf[i], 0, 3);
      if (s[i] == 'X' && a[i] < 3) {
        suf[i][a[i]]++;
      }
    }

    long[] pre = new long[3];
    long res = 0;
    for (int i = 0; i < n; i++) {
      if (s[i] == 'E') {

        int cur = a[i];

        for (int j = 0; j < 3; j++) {
          for (int k = 0; k < 3; k++) {
            f:
            for (int l = 1; l <= 3; l++) {
              for (int m = 0; m < l; m++) {
                if (m != j && m != k && m != cur) {
                  continue f;
                }
              }
              res += pre[j] * suf[i + 1][k];
            }
          }
        }
      }
      if (s[i] == 'M' && a[i] < 3) {
        pre[a[i]]++;
      }
    }
    out.println(res);
  }
}
