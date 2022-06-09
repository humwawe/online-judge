package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CHackingCypher {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    long a = in.nextInt();
    long b = in.nextInt();
    int len = s.length();
    long[] pre = new long[len];
    long cur = 0;
    for (int i = 0; i < len; i++) {
      cur = (cur * 10 + (s.charAt(i) - '0')) % a;
      pre[i] = cur;
    }
    long[] suf = new long[len];
    long base = 1;
    cur = 0;
    for (int i = len - 1; i >= 0; i--) {
      cur = ((s.charAt(i) - '0') * base + cur) % b;
      suf[i] = cur;
      base = (base * 10) % b;

    }
    for (int i = 0; i < len - 1; i++) {
      if (s.charAt(i + 1) != '0' && pre[i] == 0 && suf[i + 1] == 0) {
        out.println("YES");
        out.println(s.substring(0, i + 1));
        out.println(s.substring(i + 1));
        return;
      }
    }
    out.println("NO");
  }
}
