package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BEquivalentStrings {
  String s, t;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    t = in.nextString();
    String ns = helper(s);
    String nt = helper(t);
    if (ns.equals(nt)) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }

  private String helper(String s) {
    if (s.length() % 2 == 0) {
      String s1 = helper(s.substring(0, s.length() / 2));
      String s2 = helper(s.substring(s.length() / 2));
      if (s1.compareTo(s2) > 0) {
        return s2 + s1;
      } else {
        return s1 + s2;
      }
    }
    return s;
  }
}
