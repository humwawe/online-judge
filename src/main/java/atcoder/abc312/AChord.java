package atcoder.abc312;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AChord {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String[] strings = new String[]{"ACE", "BDF", "CEG", "DFA", "EGB", "FAC", "GBD"};
    String s = in.nextString();
    for (String string : strings) {
      if (s.equals(string)) {
        out.println("Yes");
        return;
      }
    }
    out.println("No");
  }
}
