package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CWhiteSheet {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] x = new int[6];
    int[] y = new int[6];
    for (int i = 0; i < 6; ++i) {
      x[i] = in.nextInt();
      y[i] = in.nextInt();
      x[i] *= 2;
      y[i] *= 2;
    }
    --x[2];
    ++x[3];
    --x[4];
    ++x[5];
    --y[2];
    ++y[3];
    --y[4];
    ++y[5];
    for (int i = 0; i < 6; ++i) {
      for (int j = 0; j < 6; ++j) {
        if (x[0] <= x[i] && x[i] <= x[1] && y[0] <= y[j] && y[j] <= y[1] && (x[i] <= x[2] || x[3] <= x[i] || y[j] <= y[2] || y[3] <= y[j]) && (x[i] <= x[4] || x[5] <= x[i] || y[j] <= y[4] || y[5] <= y[j])) {
          out.println("YES");
          return;
        }
      }
    }
    out.println("NO");
  }
}
