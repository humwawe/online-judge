package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AParityGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String a = in.nextString();
    String b = in.nextString();
    int cnt1 = 0;
    int cnt2 = 0;
    for (char c : a.toCharArray()) {
      if (c == '1') {
        cnt1++;
      }
    }
    if (cnt1 % 2 == 1) {
      cnt1++;
    }
    for (char c : b.toCharArray()) {
      if (c == '1') {
        cnt2++;
      }
    }
    if (cnt1 >= cnt2) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}
