package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    out.println((1L << (n + 1)) - 2);
  }
}
