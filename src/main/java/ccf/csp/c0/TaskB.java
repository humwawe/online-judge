package ccf.csp.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    char[] chars = s.toCharArray();
    int cur = 1;
    int res = 0;
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] != '-') {
        res += cur * (chars[i] - '0');
        cur++;
      }
    }
    int last = res % 11;
    if (last == 10) {
      if (chars[chars.length - 1] == 'X') {
        out.println("Right");
      } else {
        chars[chars.length - 1] = 'X';
        out.println(new String(chars));
      }
      return;
    }


    if (chars[chars.length - 1] - '0' == last) {
      out.println("Right");
    } else {
      chars[chars.length - 1] = (char) ('0' + last);
      out.println(new String(chars));
    }

  }
}
