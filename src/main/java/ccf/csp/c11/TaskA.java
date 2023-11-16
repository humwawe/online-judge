package ccf.csp.c11;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt() / 10;
    int res = n / 5 * 7;
    n %= 5;
    res += n / 3 * 4;
    res += n % 3;
    out.println(res);
  }
}
