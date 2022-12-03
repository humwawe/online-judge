package nowcoder.courses.math.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();

    long[] exgcd = MathMeth.exgcd(a, b);
    if (exgcd[2] != 1) {
      out.println(-1);
      return;
    }

    out.println((b + exgcd[0] % b) % b);


  }


}
