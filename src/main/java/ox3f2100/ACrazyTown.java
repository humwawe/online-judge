package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ACrazyTown {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x1 = in.nextInt(), y1 = in.nextInt();
    long x2 = in.nextInt(), y2 = in.nextInt();
    int n = in.nextInt();
    int ct = 0;
    for (int i = 0; i < n; i++) {
      long a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
      int sig1 = Long.signum(a * x1 + b * y1 + c);
      int sig2 = Long.signum(a * x2 + b * y2 + c);
      if (sig1 != sig2) {
        ct++;
      }
    }
    out.println(ct);
  }
}
