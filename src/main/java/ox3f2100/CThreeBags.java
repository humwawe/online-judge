package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CThreeBags {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt();
    int[] a = new int[n1];
    int[] b = new int[n2];
    int[] c = new int[n3];
    long sum1 = 0;
    long min1 = Long.MAX_VALUE;
    long sum2 = 0;
    long min2 = Long.MAX_VALUE;
    long sum3 = 0;
    long min3 = Long.MAX_VALUE;
    for (int i = 0; i < n1; i++) {
      a[i] = in.nextInt();
      sum1 += a[i];
      min1 = Math.min(min1, a[i]);
    }
    for (int i = 0; i < n2; i++) {
      b[i] = in.nextInt();
      sum2 += b[i];
      min2 = Math.min(min2, b[i]);
    }
    for (int i = 0; i < n3; i++) {
      c[i] = in.nextInt();
      sum3 += c[i];
      min3 = Math.min(min3, c[i]);
    }
    long res = 0;
    res = Math.max(res, sum2 + sum3 - sum1);
    res = Math.max(res, sum1 + sum3 - sum2);
    res = Math.max(res, sum1 + sum2 - sum3);
    res = Math.max(res, sum1 + sum2 + sum3 - 2 * Math.min(min1 + min2, Math.min(min1 + min3, min2 + min3)));
    out.println(res);
  }
}
