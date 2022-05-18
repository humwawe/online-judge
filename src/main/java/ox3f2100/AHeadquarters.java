package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AHeadquarters {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long cnt1 = 1;
    long cnt2 = 1;
    for (int i = 0; i < n; i++) {
      String s = in.nextString();
      if (s.equals("ULDR")) {
        cnt1++;
        cnt2++;
      } else if (s.equals("UR") || s.equals("DL")) {
        cnt1++;
      } else {
        cnt2++;
      }
    }
    out.println(cnt1 * cnt2);
  }
}
