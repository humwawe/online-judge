package nowcoder.courses.math.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    long[] m = new long[]{23, 28, 33};
    long[] a = new long[3];
    for (int i = 0; i < 3; i++) {
      a[i] = in.nextLong();
      a[i] %= m[i];
    }
    int d = in.nextInt();

    long[] ret = MathMeth.chineseRemainder(a, m);

    int k = 0;
    while (ret[0] + k * ret[1] <= d) {
      k++;
    }

    out.println(ret[0] + k * ret[1] - d);

  }
}
