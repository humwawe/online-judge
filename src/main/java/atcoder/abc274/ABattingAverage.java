package atcoder.abc274;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ABattingAverage {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    String res = String.format("%.3f", (double) b / a);
    out.println(res);
  }
}
