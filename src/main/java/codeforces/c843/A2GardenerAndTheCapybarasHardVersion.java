package codeforces.c843;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class A2GardenerAndTheCapybarasHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int n = s.length();
    for (int i = 1; i < n - 1; i++) {
      if (s.charAt(i) == 'a') {
        out.println(s.substring(0, i), "a", s.substring(i + 1));
        return;
      }
    }

    out.println(s.charAt(0), s.substring(1, n - 1), s.charAt(n - 1));
  }
}
