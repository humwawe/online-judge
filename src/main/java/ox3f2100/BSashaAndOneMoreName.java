package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BSashaAndOneMoreName {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    int cnt = 0;
    for (int i = 1; i < len; i++) {
      if (s.charAt(i) != s.charAt(0)) {
        cnt++;
      }
    }
    if (cnt == 0 || cnt == 1) {
      out.println("Impossible");
      return;
    }

    for (int i = 1; i < len; i++) {
      String tmp = s.substring(i) + s.substring(0, i);
      if (!tmp.equals(s) && check(tmp)) {
        out.println(1);
        return;
      }
    }
    out.println(2);
  }

  private boolean check(String tmp) {
    int i = 0;
    int j = tmp.length() - 1;
    while (i < j) {
      if (tmp.charAt(i) != tmp.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
