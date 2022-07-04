package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMikasa {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    m++;
    int res = 0;
    for (int i = 30; i > -1; i--) {
      if ((n >> i & 1) == 0 && (m >> i & 1) == 1) {
        res |= 1 << i;
      }
      if ((n >> i & 1) == 1 && (m >> i & 1) == 0) {
        break;
      }
    }
    out.println(res);
  }
}

