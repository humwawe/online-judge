package codeforces.c796;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ACirnosPerfectBitmasksClassroom {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    if (x == 1) {
      out.println(3);
      return;
    }
    int res = 0;
    for (int i = 0; i < 31; i++) {
      if (((x >> i) & 1) == 1) {
        res |= 1 << i;
        break;
      }
    }
    if (Integer.bitCount(x) == 1) {
      res |= 1;
    }
    out.println(res);
  }
}
