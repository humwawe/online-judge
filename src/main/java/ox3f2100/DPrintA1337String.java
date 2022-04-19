package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DPrintA1337String {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long t = 2;
    while ((t + 1) * t / 2 <= n) {
      t++;
    }
    long last = n - (t - 1) * t / 2;
    out.print(1);
    out.print(33);
    out.print("7".repeat((int) last));
    out.print("3".repeat((int) (t - 2)));
    out.println(7);
  }
}
