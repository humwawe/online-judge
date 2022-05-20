package codeforces.c792;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ADigitMinimization {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = String.valueOf(n);

    if (s.length() == 2) {
      out.println(s.charAt(1));
      return;
    }
    char[] chars = s.toCharArray();
    int min = 9;
    for (char aChar : chars) {
      min = Math.min(min, aChar - '0');
    }
    out.println(min);
  }
}
