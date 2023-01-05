package nowcoder.courses.ab.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskI {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int res = 0;

    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      res ^= Math.abs(a - b) - 1;

    }
    if (res != 0) {
      out.println("I WIN!");
    } else {
      out.println("BAD LUCK!");
    }
  }
}
