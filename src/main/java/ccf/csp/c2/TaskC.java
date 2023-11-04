package ccf.csp.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int t = in.nextInt();
    int n = in.nextInt();
    if (t == 0) {
      s = s.toLowerCase();
      for (int i = 0; i < n; i++) {
        String old = in.nextString();
        String tmp = old.toLowerCase();
        if (tmp.contains(s)) {
          out.println(old);
        }
      }
    } else {
      for (int i = 0; i < n; i++) {
        String tmp = in.nextString();
        if (tmp.contains(s)) {
          out.println(tmp);
        }
      }
    }
  }
}
