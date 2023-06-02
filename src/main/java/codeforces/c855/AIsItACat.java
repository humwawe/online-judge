package codeforces.c855;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AIsItACat {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString().toLowerCase();
    StringBuilder stringBuilder = new StringBuilder();
    char c = '$';

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != c) {
        stringBuilder.append(s.charAt(i));
      }
      c = s.charAt(i);
    }
    if (stringBuilder.toString().equals("meow")) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}
