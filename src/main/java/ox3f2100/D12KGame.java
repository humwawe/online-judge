package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D12KGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    if (k % 3 != 0) {
      if (n % 3 == 0) {
        out.println("Bob");
      } else {
        out.println("Alice");
      }
    } else {
      int rem = n % (k + 1);
      if (rem % 3 == 0 && rem != k) {
        out.println("Bob");
      } else {
        out.println("Alice");
      }

    }
  }
}
