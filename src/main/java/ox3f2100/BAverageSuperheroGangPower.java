package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BAverageSuperheroGangPower {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long k = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    Arrays.sort(a);
    long sum = 0;
    double res = 0;
    for (int i = n - 1; i >= 0; i--) {
      sum += a[i];
      if (m - i >= 0) {
        res = Math.max(res, (double) (sum + Math.min(m - i, (n - i) * k)) / (n - i));
      }
    }
    out.println(res);
  }
}
