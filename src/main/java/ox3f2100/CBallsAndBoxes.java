package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBallsAndBoxes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    long[] a = new long[n + 1];
    long min = (long) (1e15);
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      min = Math.min(min, a[i]);
    }
    for (int i = 1; i <= n; i++) {
      a[i] -= min;
    }
    long sum = min * n;
    for (int i = x; ; i--) {
      if (i == 0) {
        i = n;
      }
      if (a[i] != 0) {
        --a[i];
        sum++;
      } else {
        a[i] = sum;
        break;
      }
    }
    for (int i = 1; i <= n; i++) {
      out.print(a[i], "");
    }
  }
}
