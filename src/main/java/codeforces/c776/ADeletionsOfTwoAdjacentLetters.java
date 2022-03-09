package codeforces.c776;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ADeletionsOfTwoAdjacentLetters {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    char c = in.nextCharacter();
    for (int i = 0; i < s.length(); i += 2) {
      if (s.charAt(i) == c) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }
}
