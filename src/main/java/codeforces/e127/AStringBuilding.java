package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AStringBuilding {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    for (int i = 0; i < s.length(); i++) {
      int j = i;
      while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(i)) {
        j++;
      }
      if (j - i + 1 < 2) {
        out.println("NO");
        return;
      }
      i = j;
    }
    out.println("YES");
  }
}
