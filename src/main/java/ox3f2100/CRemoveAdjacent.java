package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CRemoveAdjacent {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    StringBuilder sb = new StringBuilder(s);
    sb.insert(0, '#');
    sb.append('#');
    for (char i = 'z'; i >= 'a'; i--) {
      for (int j = 1; j < sb.length() - 1; j++) {
        if (sb.charAt(j) == i) {
          if (sb.charAt(j - 1) == i - 1 || sb.charAt(j + 1) == i - 1) {
            sb.deleteCharAt(j);
            j = 0;
          }
        }
      }
    }
    out.println(n - (sb.length() - 2));

  }
}
