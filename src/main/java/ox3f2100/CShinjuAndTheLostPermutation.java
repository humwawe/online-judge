package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CShinjuAndTheLostPermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[2 * n];
    int root = -1;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      a[i + n] = a[i];
      if (a[i] == 1) {
        cnt++;
        root = i;
      }
    }
    if (cnt != 1) {
      out.println("NO");
      return;
    }
    for (int i = root + 1; i < root + n; i++) {
      if (a[i] - a[i - 1] > 1) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }
}
