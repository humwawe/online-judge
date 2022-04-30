package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DThreeLogos {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] x = new int[3];
    int[] y = new int[3];
    int max = 0;
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      x[i] = in.nextInt();
      y[i] = in.nextInt();
      if (x[i] < y[i]) {
        int t = x[i];
        x[i] = y[i];
        y[i] = t;
      }
      max = Math.max(max, x[i]);
      sum += x[i] * y[i];
    }
    if (max * max != sum) {
      out.println(-1);
      return;
    }
    out.println(max);
    String[] s = new String[]{"A", "B", "C"};
    boolean[] vis = new boolean[3];
    int last = max;
    for (int i = 0; i < 3; i++) {
      if (x[i] != max) {
        continue;
      }
      for (int j = 0; j < y[i]; j++) {
        out.println(s[i].repeat(x[i]));
      }
      vis[i] = true;
      last -= y[i];
    }
    for (int i = 0; i < last; i++) {
      for (int k = 0; k < 3; k++) {
        if (vis[k]) {
          continue;
        }
        if (x[k] == last) {
          out.print(s[k].repeat(y[k]));
        } else {
          out.print(s[k].repeat(x[k]));
        }
      }
      out.println();
    }

  }

}
