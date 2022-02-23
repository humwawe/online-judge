package codeforces.e123;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class ADoorsAndKeys {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isUpperCase(c)) {
        if (!set.contains(c)) {
          out.println("NO");
          return;
        }
      } else {
        set.add(Character.toUpperCase(c));
      }
    }
    out.println("YES");
  }
}
