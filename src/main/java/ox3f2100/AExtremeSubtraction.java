package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AExtremeSubtraction {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int d = 0;
    int min = a[0];
    for (int i = 1; i < n; i++) {
      a[i] -= d;
      if (a[i] < 0) {
        out.println("NO");
        return;
      }
      if (a[i] > min) {
        d += a[i] - min;
      } else {
        min = a[i];
      }
    }

    out.println("YES");
  }
}
