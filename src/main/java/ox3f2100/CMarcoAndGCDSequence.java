package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CMarcoAndGCDSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    int x = a[0];
    for (int i = 1; i < n; i++) {
      x = gcd(x, a[i]);
    }
    if (x != a[0]) {
      out.println(-1);
      return;
    }
    out.println(2 * n - 1);
    out.print(a[0], "");
    for (int i = 1; i < n; i++) {
      out.print(a[i], a[0], "");
    }
    out.println();

  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
