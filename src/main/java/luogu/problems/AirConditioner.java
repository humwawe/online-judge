package luogu.problems;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class AirConditioner {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long m = in.nextInt();
    int[] t = new int[n];
    int[] l = new int[n];
    int[] r = new int[n];
    for (int i = 0; i < n; i++) {
      t[i] = in.nextInt();
      l[i] = in.nextInt();
      r[i] = in.nextInt();
    }

    Integer[] idx = new Integer[n];
    Arrays.setAll(idx, i -> i);

    long min = m;
    long max = m;

    for (int ii = 0; ii < n; ii++) {
      int i = idx[ii];
      int d = t[i];
      if (i >= 1) {
        d -= t[i - 1];
      }
      max = max + d;
      min = min - d;
      if (l[i] > max || min > r[i]) {
        out.println("NO");
        return;
      }
      min = Math.max(min, l[i]);
      max = Math.min(max, r[i]);
    }
    out.println("YES");
  }
}
