package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DFillTheBag {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    int m = in.nextInt();
    int[] a = new int[m];
    long sum = 0;
    int[] cnt = new int[64];
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt();
      sum += a[i];
      cnt[Integer.numberOfTrailingZeros(a[i])]++;
    }
    if (sum < n) {
      out.println(-1);
      return;
    }
    int res = 0;
    for (int i = 0; i < 61; i++) {
      if (((n >> i) & 1) == 1) {
        if (cnt[i] == 0) {
          for (int j = i + 1; j < 61; j++) {
            if (cnt[j] > 0) {
              for (int k = j - 1; k >= i; k--) {
                cnt[k + 1]--;
                cnt[k] += 2;
              }
              res += j - i;
              break;
            }
          }
        }
        cnt[i]--;
      }
      cnt[i + 1] += cnt[i] / 2;
    }
    out.println(res);
  }

}
