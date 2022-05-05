package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class ETrainHardWinEasy {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int[][] c = new int[n][2];
    long sumA = 0;
    long sumB = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sumA += a[i];
      b[i] = in.nextInt();
      sumB += b[i];
      c[i][0] = a[i] - b[i];
      c[i][1] = i;
    }
    long[] res = new long[n];
    Arrays.sort(c, Comparator.comparingInt(x -> x[0]));
    long prevA = 0;
    long prevB = 0;
    for (int i = 0; i < n; i++) {
      int idx = c[i][1];
      res[idx] += ((long) i * b[idx] + prevA) + (long) (n - i - 1) * a[idx] + (sumB - prevB - b[idx]);
      prevA += a[idx];
      prevB += b[idx];
    }
    for (int i = 0; i < m; i++) {
      int u = in.nextInt() - 1;
      int v = in.nextInt() - 1;
      res[u] -= Math.min(a[u] + b[v], a[v] + b[u]);
      res[v] -= Math.min(a[u] + b[v], a[v] + b[u]);
    }
    out.println(res);
  }
}
