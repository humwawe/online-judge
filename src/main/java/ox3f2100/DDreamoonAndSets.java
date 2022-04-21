package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DDreamoonAndSets {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    out.println((n * 6 - 1) * k);
    int s = 1;
    for (int i = 0; i < n; i++) {
      out.println(s * k, (s + 1) * k, (s + 2) * k, (s + 4) * k);
      s += 6;
    }
  }
}
