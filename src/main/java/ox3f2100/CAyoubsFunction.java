package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAyoubsFunction {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long m = in.nextInt();
    long a = (n - m) / (m + 1);
    long b = (n - m) % (m + 1);
    long t1 = (m + 1) * (a + 1) * a / 2;
    long t2 = (a + 1) * b;
    long tot = (n + 1) * n / 2;
    out.println(tot - t1 - t2);
  }
}
