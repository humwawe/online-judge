package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DPetyaAndHisFriends {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 2) {
      out.println(-1);
      return;
    }

    out.println(6);
    long res = 1;
    for (int i = 0; i < n - 2; i++) {
      out.println(res * 2 * 17);
      res *= 2;
    }
    out.println(3 * 17);
  }


}
