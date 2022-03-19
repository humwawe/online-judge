package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ESingersTour {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    long sumB = 0;
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      sumB += b[i];
    }
    long d = (long) n * (n + 1) / 2;
    if (sumB % d != 0) {
      out.println("NO");
      return;
    }
    long sumA = sumB / d;
    for (int i = n - 1; i >= 0; i--) {
      long tmp = (b[i] - b[(i + 1) % n]) + sumA;
      if (tmp % n != 0 || tmp <= 0) {
        out.println("NO");
        return;
      }
      a[(i + 1) % n] = (int) (tmp / n);
    }
    out.println("YES");
    out.println(a);
  }
}
