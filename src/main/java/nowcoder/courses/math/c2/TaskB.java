package nowcoder.courses.math.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int p = in.nextInt();
    CombinationMath.initMod(p);
    for (int i = 1; i <= n; i++) {
      long inv = CombinationMath.inv(i);
      out.println(inv);
    }

  }
}
