package lanqiao.b1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      String s = in.nextString();
      int res = 1;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == 'L') {
          res = res * 2 - 1;
        } else {
          res = res * 2;
        }
      }
      out.println(res);
    }
  }
}
