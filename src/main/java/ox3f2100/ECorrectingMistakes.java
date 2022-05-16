package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ECorrectingMistakes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int l = n;
    int r = 0;
    String s = in.nextString();
    String t = in.nextString();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        l = Math.min(l, i);
        r = Math.max(r, i);
      }
    }
    int f1 = 1;
    int f2 = 1;
    for (int i = l + 1; i <= r; i++) {
      if (s.charAt(i) != t.charAt(i - 1)) {
        f1 = 0;
      }
      if (s.charAt(i - 1) != t.charAt(i)) {
        f2 = 0;
      }
    }
    out.println(f1 + f2);
  }
}
