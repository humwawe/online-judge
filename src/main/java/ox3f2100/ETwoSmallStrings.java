package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ETwoSmallStrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    String t = in.nextString();
    String[] can = new String[]{"abc", "acb", "bac", "bca", "cab", "cba"};
    out.println("YES");
    if (n == 1) {
      for (String c : can) {
        if (c.contains(s) || c.contains(t)) {
          continue;
        }
        out.println(c);
        return;
      }
    }

    for (String c : can) {
      if (!(c + c).contains(s) && !(c + c).contains(t)) {
        out.println(c.repeat(n));
        return;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 3; i++) {
        sb.append(("" + c.charAt(i)).repeat(n));
      }
      if (!sb.toString().contains(s) & !sb.toString().contains(t)) {
        out.println(sb.toString());
        return;
      }
    }

  }
}
