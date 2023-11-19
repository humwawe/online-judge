package ccf.csp.c13;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int res = 0;
    int last = 0;
    while (true) {
      int x = in.nextInt();
      if (x == 0) {
        break;
      }
      if (x == 1) {
        res += 1;
        last = 0;
      } else {
        last += 1;
        if (last >= 1) {
          last++;
        }
        res += last;
      }
    }
    out.println(res);

  }
}
