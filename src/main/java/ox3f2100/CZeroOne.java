package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CZeroOne {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    int a = 0;
    int b = 0;
    int c = 0;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '0') {
        a++;
      } else if (s.charAt(i) == '1') {
        b++;
      } else {
        c++;
      }
    }

    if (a + c > b) {
      out.println("00");
    }


    if (a + c + 2 > b && b >= a - c) {
      if (s.charAt(len - 1) == '0') {
        out.println("10");
      } else if (s.charAt(len - 1) == '1') {
        out.println("01");
      } else {
        if (a + c > b) {
          out.println("01");
        }
        if (b + c > a + 1) {
          out.println("10");
        }
      }
    }
    if (b + c > a + 1) {
      out.println("11");
    }

  }

}
