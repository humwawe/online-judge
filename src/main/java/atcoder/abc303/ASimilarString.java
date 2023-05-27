package atcoder.abc303;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ASimilarString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    String t = in.nextString();
    s = s.replaceAll("1", "l");
    s = s.replaceAll("0", "o");
    t = t.replaceAll("1", "l");
    t = t.replaceAll("0", "o");
    if (s.equals(t)) {
      out.println("Yes");
    } else {
      out.println("No");
    }
  }
}
