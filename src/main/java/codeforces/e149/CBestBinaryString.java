package codeforces.e149;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBestBinaryString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    char[] chars = s.toCharArray();
    char last = '0';
    for (int i = 0; i < s.length(); i++) {
      if (chars[i] == '?') {
        chars[i] = last;
      }
      last = chars[i];
    }
    out.println(new String(chars));
  }
}
