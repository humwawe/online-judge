package atcoder.abc302;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AAttack {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();
    long b = in.nextLong();
    out.println((a + b - 1) / b);
  }
}
