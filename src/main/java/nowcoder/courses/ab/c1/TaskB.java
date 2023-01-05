package nowcoder.courses.ab.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int i = 0;
    int j = n - 1;
    int b = 0;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        b++;
      }
      i++;
      j--;
    }


    int cnt0 = 0;
    for (int k = 0; k < n; k++) {
      if (s.charAt(k) == '0') {
        cnt0++;
      }
    }

    if (b != 0) {
      if (cnt0 == 0 || (cnt0 == 2 && n % 2 == 1 && s.charAt(n / 2) == '0')) {
        out.println("DRAW");
      } else {
        out.println("ALICE");
      }
      return;
    }

    if (n % 2 == 1 && s.charAt(n / 2) == '0' && cnt0 > 1) {
      out.println("ALICE");
      return;
    }
    out.println("BOB");
    //    cnt0 -= b;
    //    int a = 0;
    //
    //    a = cnt0 / 2 + 1;
    //    b += cnt0 - cnt0 / 2 - 1;
    //
    //
    //    if (a > b) {
    //      out.println("BOB");
    //    } else if (a < b) {
    //      out.println("ALICE");
    //    } else {
    //      out.println("DRAW");
    //    }
  }
}
