package codeforces.c737;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AEzzatAndTwoSubsequences {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    double[] x = new double[n];
    double sum = 0;
    double max = -Double.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      x[i] = in.nextInt();
      max = Math.max(max, x[i]);
      sum += x[i];
    }
    out.println(max + (sum - max) / (n - 1));
  }
}
