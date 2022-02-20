package codeforces.e113;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ABalancedSubstring {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == 'a' && s.charAt(i + 1) == 'b') {
        out.println((i + 1) + " " + (i + 2));
        return;
      }
      if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') {
        out.println((i + 1) + " " + (i + 2));
        return;
      }
    }
    out.println(-1 + " " + -1);
  }
}
