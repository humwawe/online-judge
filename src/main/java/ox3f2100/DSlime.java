package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DSlime {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    long min = Integer.MAX_VALUE;
    long max = Integer.MIN_VALUE;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      sum += Math.abs(x);
      min = Math.min(min, x);
      max = Math.max(max, x);
    }
    if (n == 1) {
      out.println(max);
      return;
    }
    out.println(max - min + sum - Math.abs(max) - Math.abs(min));
  }
}
