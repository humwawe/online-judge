package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BFishWeight {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt();
    }
    if (n > m) {
      out.println("YES");
      return;
    }
    Arrays.sort(a);
    Arrays.sort(b);
    for (int i = 0; i < n; i++) {
      if (a[i] > b[m - n + i]) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }
}
