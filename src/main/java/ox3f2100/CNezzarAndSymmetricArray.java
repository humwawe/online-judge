package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CNezzarAndSymmetricArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = new long[2 * n];
    for (int i = 0; i < 2 * n; i++) {
      a[i] = in.nextLong();
    }
    Arrays.sort(a);
    long[] b = new long[n];
    for (int i = 0; i < 2 * n; i += 2) {
      if (a[i] != a[i + 1] || a[i] % 2 != 0) {
        out.println("NO");
        return;
      }
      b[i / 2] = a[i] / 2;
    }
    long sum = 0;
    Set<Long> set = new HashSet<>();
    for (int i = n; i >= 1; i--) {
      if ((b[i - 1] - sum) <= 0 || (b[i - 1] - sum) % i != 0) {
        out.println("NO");
        return;
      }
      set.add((b[i - 1] - sum) / i);
      sum += (b[i - 1] - sum) / i;
    }
    if (set.size() != n) {
      out.println("NO");
      return;
    }
    out.println("YES");
  }
}
