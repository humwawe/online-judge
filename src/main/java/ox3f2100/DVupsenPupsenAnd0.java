package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DVupsenPupsenAnd0 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    if (n % 2 == 0) {
      for (int i = 0; i < n; i += 2) {
        out.print(-a[i + 1] + " ");
        out.print(a[i] + " ");
      }
    } else {
      if (a[0] + a[1] != 0) {
        out.print(-a[2] + " ");
        out.print(-a[2] + " ");
        out.print((a[0] + a[1]) + " ");
      } else if (a[0] + a[2] != 0) {
        out.print(-a[1] + " ");
        out.print((a[0] + a[2]) + " ");
        out.print(-a[1] + " ");
      } else {
        out.print((a[1] + a[2]) + " ");
        out.print(-a[0] + " ");
        out.print(-a[0] + " ");
      }
      for (int i = 3; i < n; i += 2) {
        out.print(-a[i + 1] + " ");
        out.print(a[i] + " ");
      }
    }
    out.println();
  }
}
