package atcoder.abc298;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AJobInterview {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    boolean good = false;
    boolean poor = false;
    for (char c : s.toCharArray()) {
      if (c == 'o') {
        good = true;
      }
      if (c == 'x') {
        poor = true;
      }
    }
    if (good && !poor) {
      out.println("Yes");
    } else {
      out.println("No");
    }
  }
}
