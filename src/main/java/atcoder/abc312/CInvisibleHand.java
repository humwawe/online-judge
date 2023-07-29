package atcoder.abc312;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CInvisibleHand {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();

    int[] a = in.nextInt(n);
    int[] b = in.nextInt(m);
    Arrays.sort(a);
    Arrays.sort(b);

    int l = 0;
    int r = (int) (1e9 + 1);
    while (l < r) {
      int mid = l + r >> 1;
      int x = 0;
      for (int i = 0; i < n; i++) {
        if (a[i] <= mid) {
          x++;
        }
      }
      int y = 0;
      for (int i = 0; i < m; i++) {
        if (b[i] >= mid) {
          y++;
        }
      }
      if (x >= y) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    out.println(l);
  }
}
