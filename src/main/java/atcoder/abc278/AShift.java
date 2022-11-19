package atcoder.abc278;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AShift {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = new int[n];
    int j = 0;
    for (int i = k; i < n; i++) {
      b[j++] = a[i];
    }
    out.println(b);
  }
}
