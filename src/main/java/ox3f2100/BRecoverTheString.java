package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BRecoverTheString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextInt();
    long b = in.nextInt();
    long c = in.nextInt();
    long d = in.nextInt();
    if (a == 0 && b == 0 && c == 0 && d == 0) {
      out.println(0);
      return;
    }
    long cnt1 = 0;
    long cnt2 = 0;
    if (b != 0 || c != 0) {
      cnt1 = 1;
      cnt2 = 1;
    }
    while (cnt1 * (cnt1 - 1) / 2 < a) {
      cnt1++;
    }

    if (cnt1 * (cnt1 - 1) / 2 != a) {
      out.println("Impossible");
      return;
    }
    while (cnt2 * (cnt2 - 1) / 2 < d) {
      cnt2++;
    }
    if (cnt2 * (cnt2 - 1) / 2 != d) {
      out.println("Impossible");
      return;
    }
    if (cnt1 * cnt2 != b + c) {
      out.println("Impossible");
      return;
    }
    long n = cnt1 + cnt2;
    for (long i = 0; i < n; i++) {
      if (cnt1 > 0 && b >= cnt2) {
        out.print(0);
        b -= cnt2;
        cnt1--;
      } else {
        out.print(1);
        cnt2--;
      }
    }
  }
}
