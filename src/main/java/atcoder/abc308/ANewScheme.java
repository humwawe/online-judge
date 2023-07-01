package atcoder.abc308;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ANewScheme {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = 8;
    int[] a = in.nextInt(n);
    for (int i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        out.println("No");
        return;
      }
    }

    for (int i = 0; i < n; i++) {
      if (a[i] < 100 || a[i] > 675) {
        out.println("No");
        return;
      }
      if (a[i] % 25 != 0) {
        out.println("No");
        return;
      }
    }
    out.println("Yes");
  }
}
