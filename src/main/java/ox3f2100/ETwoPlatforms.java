package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class ETwoPlatforms {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.nextInt();
    }

    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      y[i] = in.nextInt();
    }

    Arrays.sort(x);

    int[] suf = new int[n];
    int j = 0;
    for (int i = 0; i < n; i++) {
      while (j + 1 < n && x[j + 1] <= x[i] + k) {
        j++;
      }
      suf[i] = j;
    }
    int[] max = new int[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      max[i] = Math.max(max[i + 1], suf[i] - i + 1);
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, suf[i] - i + 1 + max[suf[i] + 1]);
    }

    out.println(res);

  }


}
