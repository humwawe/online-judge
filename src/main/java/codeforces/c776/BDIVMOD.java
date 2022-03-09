package codeforces.c776;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BDIVMOD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int l = in.nextInt();
    int r = in.nextInt();
    int a = in.nextInt();
    int x = r / a;
    int y = r % a;
    if (y != a - 1) {
      if ((x - 1) * a + (a - 1) >= l) {
        out.println((x - 1) + (a - 1));
        return;
      }
    }
    out.println(x + y);
  }
}
