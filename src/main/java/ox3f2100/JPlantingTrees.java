package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class JPlantingTrees {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    if (n == 1 && m == 1) {
      out.println(1);
      return;
    }
    if (n + m < 5) {
      out.println(-1);
      return;
    }
    int min = 1;
    int max = n * m / 2 + 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if ((i + j) % 2 == 1) {
          out.print(min++, "");
        } else {
          out.print(max++, "");
        }
      }
      out.println();
    }
  }
}
