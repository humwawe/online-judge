package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CDisposition {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 2; i <= n; i++) {
      out.print(i, "");
    }
    out.println(1);
  }
}
