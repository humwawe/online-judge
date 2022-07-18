package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CWaterTheTrees {
  int n;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      max = Math.max(max, a[i]);
    }

    out.println(Math.min(helper(max), helper(max + 1)));
  }

  private long helper(int max) {
    long cnt1 = 0;
    long cnt2 = 0;
    for (int i = 0; i < n; i++) {
      cnt1 += (max - a[i]) % 2;
      cnt2 += (max - a[i]) / 2;
    }

    long tmp = cnt2 - cnt1;
    if (tmp >= 2) {
      cnt1 += (tmp + 1) / 3 * 2;
      cnt2 -= (tmp + 1) / 3;
    }
    if (cnt1 > cnt2) {
      return cnt1 * 2 - 1;
    } else {
      return cnt2 * 2;
    }

  }
}
