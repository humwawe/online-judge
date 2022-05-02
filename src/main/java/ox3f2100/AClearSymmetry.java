package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AClearSymmetry {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 3) {
      out.println(5);
      return;
    }
    for (int i = 1; ; i += 2) {
      int tmp = (i * i + 1) / 2;
      if (n <= tmp) {
        out.println(i);
        return;
      }
    }
  }
}
