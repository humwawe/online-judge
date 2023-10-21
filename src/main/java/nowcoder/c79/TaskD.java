package nowcoder.c79;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    int res = 20;
    for (int i = 0; i <= 20; i++) {
      int t = (1 << i) - 1;
      if ((x & t) == 0) {
        res = Math.min(res, 20 - i);
      } else {
        int tmp = ((x & t ^ t) + 1);
        res = Math.min(res, 20 - i + tmp);
      }

    }
    out.println(res);
  }
}
