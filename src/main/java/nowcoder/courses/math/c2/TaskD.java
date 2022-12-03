package nowcoder.courses.math.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] p = new long[n];
    long[] r = new long[n];
    for (int i = 0; i < n; i++) {
      p[i] = in.nextLong();
      r[i] = in.nextLong();
    }
    out.println(MathMeth.exChineseRemainder(r, p)[0]);
  }
}
