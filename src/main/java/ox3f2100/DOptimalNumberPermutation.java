package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DOptimalNumberPermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[2 * n];
    int i1 = 0;
    int i2 = n - 1;
    for (int i = 1; i < n; i += 2) {
      a[i1] = i;
      a[i2] = i;
      i1++;
      i2--;
    }
    i1 = n;
    i2 = 2 * n - 2;
    for (int i = 2; i < n; i += 2) {
      a[i1] = i;
      a[i2] = i;
      i1++;
      i2--;
    }
    for (int i = 0; i < 2 * n; i++) {
      if (a[i] == 0) {
        a[i] = n;
      }
    }
    out.println(a);
  }
}
