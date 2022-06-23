package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTheBestVacation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long x = in.nextLong();
    int[] a = new int[n * 2];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      a[i + n] = a[i];
    }
    int j = 0;
    long sum = 0;
    long val = 0;
    long res = 0;
    for (int i = 0; i < n * 2; i++) {
      sum += a[i];
      val += helper(a[i]);
      while (sum - a[j] >= x) {
        sum -= a[j];
        val -= helper(a[j]);
        j++;
      }
      if (sum >= x) {
        res = Math.max(res, val - helper(sum - x));
      }
    }
    out.println(res);


  }

  private long helper(long i) {
    return i * (i + 1) / 2;
  }
}
