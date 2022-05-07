package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BParty {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 1) {
      out.println(0);
      return;
    }
    out.println(n - 2);

  }
}
