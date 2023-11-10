package ccf.csp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int res = 0;
    while (n > 0) {
      res += n % 10;
      n /= 10;
    }
    out.println(res);
  }
}
