package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CHiddenWord {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int a = 0;
    int b = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          a = i;
          b = j;
        }
      }
    }
    if (a + 1 == b) {
      out.println("Impossible");
      return;
    }
    int mid = a + (b - a + 1) / 2;
    for (int i = 0, j = mid; i < 13; i++, j++) {
      if (j % 27 == b) {
        j++;
      }
      out.print(s.charAt((j + 27) % 27));
    }
    out.println();
    for (int i = 0, j = mid - 1; i < 13; i++, j--) {
      out.print(s.charAt((j + 27) % 27));
    }

  }
}
