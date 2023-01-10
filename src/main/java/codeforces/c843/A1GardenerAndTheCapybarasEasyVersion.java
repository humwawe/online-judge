package codeforces.c843;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class A1GardenerAndTheCapybarasEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int n = s.length();
    for (int i = 1; i <= n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        String a = s.substring(0, i);
        String b = s.substring(i, j);
        String c = s.substring(j);
        if (a.compareTo(b) <= 0 && c.compareTo(b) <= 0) {
          out.println(a, b, c);
          return;
        }
        if (a.compareTo(b) >= 0 && c.compareTo(b) >= 0) {
          out.println(a, b, c);
          return;
        }
      }
    }
  }
}
