package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DReverseSortSum {


  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int[] res = new int[n + 1];
    Arrays.fill(res, 1);
    int idx = -1;
    while (idx < n - 1 && a[++idx] == 0) {
      res[idx] = 0;
    }
    for (; idx < n; idx++) {
      int k = a[idx] - idx * res[idx];
      res[k + idx] = 0;
    }

    for (int i = 0; i < n; i++) {
      out.print(res[i], "");
    }
    out.println();
  }
}
