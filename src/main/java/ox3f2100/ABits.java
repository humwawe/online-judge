package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ABits {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      long l = in.nextLong();
      long r = in.nextLong();
      long res = l;
      for (int j = 0; j < 64; j++) {
        if (((l >> j) & 1) == 0) {
          if ((res | (1L << j)) <= r) {
            res |= 1L << j;
          } else {
            break;
          }
        }
      }
      out.println(res);
    }
  }
}
