package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class B2PalindromeGameHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int cnt0 = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '0') {
        cnt0++;
      }
    }
    boolean isP = true;
    for (int i = 0; i < n / 2; i++) {
      if (s.charAt(i) != s.charAt(n - 1 - i)) {
        isP = false;
        break;
      }
    }
    if (isP) {
      if (cnt0 != 1 && cnt0 % 2 == 1) {
        out.println("ALICE");
        return;
      }
      out.println("BOB");
      return;
    }

    if (n % 2 == 1 && cnt0 == 2 && s.charAt(n / 2) == '0') {
      out.println("DRAW");
      return;
    }
    out.println("ALICE");

  }

}
