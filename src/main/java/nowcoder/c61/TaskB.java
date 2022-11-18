package nowcoder.c61;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String a1 = in.nextString();
    String a2 = in.nextString();
    if (a2.charAt(0) == '0') {
      out.println("PLMM");
      return;
    }
    if (a2.charAt(0) > '5') {
      out.println("Happy birthday to MFGG");
    } else if (a2.charAt(0) < '5') {
      out.println("Happy birthday to YXGG");
    } else if (a2.charAt(0) == '5') {
      if (check(a2)) {
        if ((a1.charAt(a1.length() - 1) - '0') % 2 == 0) {
          out.println("Happy birthday to YXGG");
        } else {
          out.println("Happy birthday to MFGG");
        }
      } else {
        out.println("Happy birthday to MFGG");
      }

    }
  }

  private boolean check(String a2) {
    for (int i = 1; i < a2.length(); i++) {
      if (a2.charAt(i) != '0') {
        return false;
      }
    }
    return true;
  }
}
