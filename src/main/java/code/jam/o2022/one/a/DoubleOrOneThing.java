package code.jam.o2022.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DoubleOrOneThing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    out.printf("Case #%d: ", testNumber);
    String s = in.nextString();
    int len = s.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; ) {
      int j = i;
      while (j + 1 < len && s.charAt(j + 1) == s.charAt(i)) {
        j++;
      }
      if (j + 1 < len && s.charAt(j + 1) > s.charAt(i)) {
        sb.append(("" + s.charAt(i)).repeat(2 * (j - i + 1)));
      } else {
        sb.append(("" + s.charAt(i)).repeat((j - i + 1)));
      }
      i = j + 1;
    }
    out.println(sb.toString());
  }
}
