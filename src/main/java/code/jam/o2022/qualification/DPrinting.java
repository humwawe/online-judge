package code.jam.o2022.qualification;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DPrinting {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[][] a = new int[3][4];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        a[i][j] = in.nextInt();
      }
    }

    int lim = (int) 1e6;
    int sum = 0;
    int[] min = new int[4];
    Arrays.fill(min, lim + 5);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        min[i] = Math.min(min[i], a[j][i]);
      }
      sum += min[i];
    }
    if (sum < lim) {
      out.printf("Case #%d: ", testNumber);
      out.println("IMPOSSIBLE");
      return;
    }
    int[] res = new int[4];
    for (int i = 0; i < 4; i++) {
      res[i] = Math.min(lim, min[i]);
      lim -= res[i];
    }
    out.printf("Case #%d: ", testNumber);
    out.println(res);
  }
}
