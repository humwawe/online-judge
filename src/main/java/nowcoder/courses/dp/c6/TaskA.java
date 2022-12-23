package nowcoder.courses.dp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = in.nextInt();
    int x = in.nextInt();

    if (k >= 2 * x) {
      out.println("0.00");
    } else if (k >= x) {
      out.printf("%.2f\n", Math.pow((2.0 * x - k) / x, 2) / 2.0);
    } else {
      out.printf("%.2f\n", 1.0 - 0.5 * Math.pow((double) k / x, 2));
    }
  }
}
