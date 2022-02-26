package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BDifferentRules {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    int res1 = Math.min(n, Math.max(1, x + y - n + 1));
    int res2 = Math.min(n, x + y - 1);
    out.println(res1, res2);
  }
}
