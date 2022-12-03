package acwing.contest.weekly.c80;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readLine().toLowerCase();
    char c = ' ';
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ' && s.charAt(i) != '?') {
        c = s.charAt(i);
        break;
      }
    }
    char[] chars = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
    for (int i = 0; i < chars.length; i++) {
      if (c == chars[i]) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }
}
