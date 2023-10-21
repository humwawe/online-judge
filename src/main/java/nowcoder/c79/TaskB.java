package nowcoder.c79;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int sum = 0;
    int t = (int) 1e5;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (x % 2 == 1) {
        t = Math.min(t, x);
      }
      sum += x;
    }
    if (sum % 2 == 0) {
      out.println(sum);
    } else {
      out.println(sum - t);
    }

  }
}
